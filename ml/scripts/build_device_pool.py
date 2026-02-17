#!/usr/bin/env python3
"""Build a unified public device pool for pretraining.

Sources:
- backend/data/spec_catalog.json
- backend/data/spec_catalog_croma.json
- backend/data/spec_catalog_trusted.json
- optional AutoEq clone at ml/public/AutoEq
"""

from __future__ import annotations

import argparse
import json
import re
from dataclasses import dataclass
from pathlib import Path
from typing import Dict, Iterable, List, Optional

import pandas as pd


DEFAULT_SPECS = {
    "earbuds": {
        "driver_mm": 10.0,
        "impedance_ohm": 16.0,
        "sensitivity_db_mw": 102.0,
        "power_mw": 20.0,
        "frequency_low_hz": 20,
        "frequency_high_hz": 20000,
    },
    "headphones": {
        "driver_mm": 40.0,
        "impedance_ohm": 32.0,
        "sensitivity_db_mw": 100.0,
        "power_mw": 30.0,
        "frequency_low_hz": 20,
        "frequency_high_hz": 20000,
    },
}


@dataclass
class DeviceRow:
    brand: str
    model: str
    device_type: str
    driver_mm: Optional[float]
    frequency_low_hz: Optional[int]
    frequency_high_hz: Optional[int]
    impedance_ohm: Optional[float]
    sensitivity_db_mw: Optional[float]
    power_mw: Optional[float]
    source: str

    @property
    def key(self) -> str:
        return normalize(f"{self.brand} {self.model}")


def normalize(text: str) -> str:
    return re.sub(r"[^a-z0-9]+", " ", text.lower()).strip()


def infer_device_type(text: str) -> str:
    t = normalize(text)
    if re.search(
        r"\b(buds|earbuds|earphones|tws|in ear|in ear|in-ear|neckband|airpods)\b", t
    ):
        return "earbuds"
    if re.search(r"\b(headphones|headphone|over ear|over-ear|on ear|on-ear)\b", t):
        return "headphones"
    return "earbuds"


def read_json(path: Path) -> List[dict]:
    if not path.exists():
        return []
    with path.open("r", encoding="utf-8") as handle:
        return json.load(handle)


def from_catalog_entry(entry: dict, source: str) -> DeviceRow:
    brand = str(entry.get("brand") or "Unknown").strip()
    model = str(entry.get("model") or "Unknown").strip()
    device_type = infer_device_type(f"{brand} {model}")
    return DeviceRow(
        brand=brand,
        model=model,
        device_type=device_type,
        driver_mm=entry.get("driverSizeMm"),
        frequency_low_hz=entry.get("frequencyLowHz"),
        frequency_high_hz=entry.get("frequencyHighHz"),
        impedance_ohm=entry.get("impedanceOhm"),
        sensitivity_db_mw=entry.get("sensitivityDb"),
        power_mw=entry.get("powerMw"),
        source=source,
    )


def iter_autoeq_devices(autoeq_root: Path) -> Iterable[DeviceRow]:
    """Extract brand/model names from AutoEq result folder structure."""

    results_dir = autoeq_root / "results"
    if not results_dir.exists():
        return []

    rows: List[DeviceRow] = []
    # Typical structure: results/<brand>/<model>/...
    for brand_dir in sorted([p for p in results_dir.iterdir() if p.is_dir()]):
        brand = brand_dir.name
        for model_dir in sorted([p for p in brand_dir.iterdir() if p.is_dir()]):
            model = model_dir.name
            device_type = infer_device_type(f"{brand} {model}")
            rows.append(
                DeviceRow(
                    brand=brand,
                    model=model,
                    device_type=device_type,
                    driver_mm=None,
                    frequency_low_hz=None,
                    frequency_high_hz=None,
                    impedance_ohm=None,
                    sensitivity_db_mw=None,
                    power_mw=None,
                    source="autoeq",
                )
            )
    return rows


def merge_rows(rows: Iterable[DeviceRow]) -> List[dict]:
    merged: Dict[str, dict] = {}
    for row in rows:
        existing = merged.get(row.key)
        if existing is None:
            merged[row.key] = {
                "brand": row.brand,
                "model": row.model,
                "display_name": f"{row.brand} {row.model}".strip(),
                "device_type": row.device_type,
                "driver_mm": row.driver_mm,
                "frequency_low_hz": row.frequency_low_hz,
                "frequency_high_hz": row.frequency_high_hz,
                "impedance_ohm": row.impedance_ohm,
                "sensitivity_db_mw": row.sensitivity_db_mw,
                "power_mw": row.power_mw,
                "sources": {row.source},
            }
            continue

        # Prefer non-null values from any source; keep first non-null.
        for field in [
            "driver_mm",
            "frequency_low_hz",
            "frequency_high_hz",
            "impedance_ohm",
            "sensitivity_db_mw",
            "power_mw",
        ]:
            if existing[field] is None and getattr(row, field) is not None:
                existing[field] = getattr(row, field)
        existing["sources"].add(row.source)

    output: List[dict] = []
    for _, rec in merged.items():
        defaults = DEFAULT_SPECS[rec["device_type"]]
        inferred_fields: List[str] = []
        for field in [
            "driver_mm",
            "frequency_low_hz",
            "frequency_high_hz",
            "impedance_ohm",
            "sensitivity_db_mw",
            "power_mw",
        ]:
            if rec[field] is None:
                rec[field] = defaults[field]
                inferred_fields.append(field)

        output.append(
            {
                "device_id": normalize(rec["display_name"]),
                "brand": rec["brand"],
                "model": rec["model"],
                "display_name": rec["display_name"],
                "device_type": rec["device_type"],
                "driver_mm": float(rec["driver_mm"]),
                "frequency_low_hz": int(rec["frequency_low_hz"]),
                "frequency_high_hz": int(rec["frequency_high_hz"]),
                "impedance_ohm": float(rec["impedance_ohm"]),
                "sensitivity_db_mw": float(rec["sensitivity_db_mw"]),
                "power_mw": float(rec["power_mw"]),
                "source": " + ".join(sorted(rec["sources"])),
                "inferred_spec_fields": ";".join(inferred_fields),
            }
        )
    return output


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--project-root",
        type=Path,
        default=Path(__file__).resolve().parents[2],
        help="Project root directory (default: repository root).",
    )
    parser.add_argument(
        "--autoeq-root",
        type=Path,
        default=None,
        help="Optional AutoEq root path. If omitted, tries ml/public/AutoEq under project root.",
    )
    parser.add_argument(
        "--output",
        type=Path,
        default=None,
        help="Output CSV path (default: ml/data/device_pool.csv under project root).",
    )
    args = parser.parse_args()

    project_root = args.project_root.resolve()
    backend_data = project_root / "backend" / "data"
    output = args.output or (project_root / "ml" / "data" / "device_pool.csv")
    autoeq_root = args.autoeq_root or (project_root / "ml" / "public" / "AutoEq")

    rows: List[DeviceRow] = []
    rows.extend(
        from_catalog_entry(entry, "spec_catalog")
        for entry in read_json(backend_data / "spec_catalog.json")
    )
    rows.extend(
        from_catalog_entry(entry, "spec_catalog_croma")
        for entry in read_json(backend_data / "spec_catalog_croma.json")
    )
    rows.extend(
        from_catalog_entry(entry, "spec_catalog_trusted")
        for entry in read_json(backend_data / "spec_catalog_trusted.json")
    )

    autoeq_rows = list(iter_autoeq_devices(autoeq_root))
    rows.extend(autoeq_rows)

    merged = merge_rows(rows)
    output.parent.mkdir(parents=True, exist_ok=True)
    pd.DataFrame(merged).sort_values("display_name").to_csv(output, index=False)

    print(f"Saved device pool: {output}")
    print(f"Total unique devices: {len(merged)}")
    print(f"AutoEq devices added: {len(autoeq_rows)}")


if __name__ == "__main__":
    main()

