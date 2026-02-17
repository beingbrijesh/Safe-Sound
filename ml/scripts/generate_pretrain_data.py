#!/usr/bin/env python3
"""Generate synthetic WHO/H.870-based pretraining data.

This script uses a public device pool and creates session-level samples with:
- averageVolumeFraction
- totalDurationMinutes
- averageDb
- dosePercent
- targetMultiplier
"""

from __future__ import annotations

import argparse
from pathlib import Path

import numpy as np
import pandas as pd


FEATURE_COLUMNS = [
    "averageVolumeFraction",
    "totalDurationMinutes",
    "averageDb",
    "dosePercent",
]


def safe_hours_h870(dba: np.ndarray, lref: np.ndarray) -> np.ndarray:
    return 40.0 * np.power(2.0, (lref - dba) / 3.0)


def estimate_dba(
    volume_fraction: np.ndarray,
    sensitivity_db_mw: np.ndarray,
    impedance_ohm: np.ndarray,
    device_type: np.ndarray,
    rng: np.random.Generator,
) -> np.ndarray:
    # Lightweight SPL approximation:
    # Lp = Sensitivity + 10*log10(PmW/1mW), where PmW from Vrms^2 / R * 1000.
    wired_like = np.where(device_type == "headphones", 1.0, 0.0)
    max_vrms = np.where(
        wired_like > 0.5,
        rng.uniform(0.7, 1.2, size=volume_fraction.shape[0]),
        rng.uniform(0.25, 0.65, size=volume_fraction.shape[0]),
    )
    vrms = max_vrms * np.power(np.clip(volume_fraction, 0.0, 1.0), 1.6)
    power_mw = ((vrms**2) / np.maximum(impedance_ohm, 1e-3)) * 1000.0
    raw_spl = sensitivity_db_mw + 10.0 * np.log10(np.maximum(power_mw, 1e-6))
    fit_adjust = rng.normal(0.0, 1.5, size=volume_fraction.shape[0])
    return np.clip(raw_spl + fit_adjust, 55.0, 110.0)


def build_multiplier_label(
    dba: np.ndarray,
    duration_minutes: np.ndarray,
    window_after_dose: np.ndarray,
    mode: np.ndarray,
    rng: np.random.Generator,
) -> np.ndarray:
    mult = np.ones_like(dba)
    mult += np.where(dba >= 85, 0.08, 0.0)
    mult += np.where(dba >= 90, 0.12, 0.0)
    mult += np.where(dba >= 95, 0.20, 0.0)
    mult += np.where(duration_minutes >= 30, 0.05, 0.0)
    mult += np.where(duration_minutes >= 60, 0.08, 0.0)
    mult += np.where(duration_minutes >= 120, 0.15, 0.0)
    mult += np.where(window_after_dose >= 100, 0.18, 0.0)
    mult += np.where(window_after_dose >= 150, 0.25, 0.0)
    mult += np.where(mode == "MODE2", 0.10, 0.0)
    mult += rng.normal(0.0, 0.03, size=dba.shape[0])
    return np.clip(mult, 0.5, 2.0)


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--project-root",
        type=Path,
        default=Path(__file__).resolve().parents[2],
        help="Project root directory (default: repository root).",
    )
    parser.add_argument(
        "--device-pool",
        type=Path,
        default=None,
        help="Input device pool CSV (default: ml/data/device_pool.csv).",
    )
    parser.add_argument(
        "--output",
        type=Path,
        default=None,
        help="Output CSV path (default: ml/data/pretrain_dataset.csv).",
    )
    parser.add_argument(
        "--rows",
        type=int,
        default=300_000,
        help="Number of synthetic rows to generate.",
    )
    parser.add_argument(
        "--seed",
        type=int,
        default=42,
        help="Random seed.",
    )
    parser.add_argument(
        "--window-days",
        type=float,
        default=1.0,
        help="Dose reference window in days (default: 1.0 for daily UI). Use 7 for strict weekly.",
    )
    args = parser.parse_args()

    project_root = args.project_root.resolve()
    device_pool_path = args.device_pool or (project_root / "ml" / "data" / "device_pool.csv")
    output_path = args.output or (project_root / "ml" / "data" / "pretrain_dataset.csv")

    if not device_pool_path.exists():
        raise FileNotFoundError(
            f"Device pool not found: {device_pool_path}. Run build_device_pool.py first."
        )

    rng = np.random.default_rng(args.seed)
    devices = pd.read_csv(device_pool_path)
    if devices.empty:
        raise ValueError("Device pool is empty.")

    idx = rng.integers(0, len(devices), size=args.rows)
    sampled = devices.iloc[idx].reset_index(drop=True)

    volume = np.clip(rng.beta(2.2, 2.0, size=args.rows), 0.03, 1.0)
    duration_minutes = np.clip(rng.lognormal(mean=3.0, sigma=0.7, size=args.rows), 1.0, 360.0)

    mode = np.where(rng.random(args.rows) < 0.2, "MODE2", "MODE1")
    lref = np.where(mode == "MODE2", 75.0, 80.0)

    dba = estimate_dba(
        volume_fraction=volume,
        sensitivity_db_mw=sampled["sensitivity_db_mw"].to_numpy(dtype="float64"),
        impedance_ohm=sampled["impedance_ohm"].to_numpy(dtype="float64"),
        device_type=sampled["device_type"].to_numpy(dtype=str),
        rng=rng,
    )

    window_days = max(0.25, min(7.0, float(args.window_days)))
    safe_hours_week = safe_hours_h870(dba=dba, lref=lref)
    safe_hours = safe_hours_week * (window_days / 7.0)
    dose_percent = np.clip((duration_minutes / 60.0) / safe_hours * 100.0, 0.0, 250.0)

    window_before = rng.uniform(0.0, 120.0 if window_days >= 7 else 70.0, size=args.rows)
    window_after = window_before + dose_percent

    target_multiplier = build_multiplier_label(
        dba=dba,
        duration_minutes=duration_minutes,
        window_after_dose=window_after,
        mode=mode,
        rng=rng,
    )

    out = pd.DataFrame(
        {
            "averageVolumeFraction": np.round(volume, 5),
            "totalDurationMinutes": np.round(duration_minutes, 5),
            "averageDb": np.round(dba, 5),
            "dosePercent": np.round(dose_percent, 5),
            "targetMultiplier": np.round(target_multiplier, 5),
            "mode": mode,
            "windowDays": window_days,
            "windowDoseBefore": np.round(window_before, 5),
            "windowDoseAfter": np.round(window_after, 5),
            "deviceType": sampled["device_type"].astype(str),
            "brand": sampled["brand"].astype(str),
            "model": sampled["model"].astype(str),
        }
    )

    output_path.parent.mkdir(parents=True, exist_ok=True)
    out.to_csv(output_path, index=False)

    print(f"Saved synthetic dataset: {output_path}")
    print(f"Rows: {len(out)}")
    print("Feature columns (in order):", ", ".join(FEATURE_COLUMNS))


if __name__ == "__main__":
    main()
