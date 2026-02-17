#!/usr/bin/env python3
"""Train risk multiplier model and export TFLite."""

from __future__ import annotations

import argparse
import json
from pathlib import Path

import numpy as np
import pandas as pd
import tensorflow as tf
from sklearn.model_selection import train_test_split


FEATURES = [
    "averageVolumeFraction",
    "totalDurationMinutes",
    "averageDb",
    "dosePercent",
]
TARGET = "targetMultiplier"


def build_model(x_train: np.ndarray) -> tf.keras.Model:
    normalizer = tf.keras.layers.Normalization(axis=-1, name="feature_norm")
    normalizer.adapt(x_train)

    inputs = tf.keras.Input(shape=(len(FEATURES),), name="features")
    x = normalizer(inputs)
    x = tf.keras.layers.Dense(32, activation="relu")(x)
    x = tf.keras.layers.Dense(16, activation="relu")(x)
    x = tf.keras.layers.Dense(1, activation="sigmoid")(x)
    outputs = tf.keras.layers.Lambda(lambda t: 0.5 + (t * 1.5), name="multiplier")(x)

    model = tf.keras.Model(inputs=inputs, outputs=outputs, name="safesound_risk_multiplier")
    model.compile(
        optimizer=tf.keras.optimizers.Adam(1e-3),
        loss=tf.keras.losses.Huber(delta=0.1),
        metrics=[tf.keras.metrics.MeanAbsoluteError(name="mae")],
    )
    return model


def monotonic_check(model: tf.keras.Model) -> dict:
    # Keep duration fixed, raise volume.
    low = np.array([[0.3, 30.0, 75.0, 2.0]], dtype=np.float32)
    high = np.array([[0.8, 30.0, 92.0, 12.0]], dtype=np.float32)
    # Keep volume fixed, raise duration and dose.
    short = np.array([[0.6, 10.0, 85.0, 1.5]], dtype=np.float32)
    long = np.array([[0.6, 120.0, 85.0, 18.0]], dtype=np.float32)

    pred_low = float(model.predict(low, verbose=0).reshape(-1)[0])
    pred_high = float(model.predict(high, verbose=0).reshape(-1)[0])
    pred_short = float(model.predict(short, verbose=0).reshape(-1)[0])
    pred_long = float(model.predict(long, verbose=0).reshape(-1)[0])

    return {
        "volume_monotonic_ok": pred_high >= pred_low,
        "duration_monotonic_ok": pred_long >= pred_short,
        "sample_preds": {
            "low": pred_low,
            "high": pred_high,
            "short": pred_short,
            "long": pred_long,
        },
    }


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--project-root",
        type=Path,
        default=Path(__file__).resolve().parents[2],
        help="Project root directory (default: repository root).",
    )
    parser.add_argument(
        "--input",
        type=Path,
        default=None,
        help="Input training CSV (default: ml/data/pretrain_dataset.csv).",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        default=None,
        help="Output directory (default: ml/models).",
    )
    parser.add_argument("--epochs", type=int, default=80)
    parser.add_argument("--batch-size", type=int, default=256)
    parser.add_argument("--seed", type=int, default=42)
    args = parser.parse_args()

    tf.keras.utils.set_random_seed(args.seed)
    np.random.seed(args.seed)

    project_root = args.project_root.resolve()
    input_path = args.input or (project_root / "ml" / "data" / "pretrain_dataset.csv")
    output_dir = args.output_dir or (project_root / "ml" / "models")
    output_dir.mkdir(parents=True, exist_ok=True)

    if not input_path.exists():
        raise FileNotFoundError(f"Training data not found: {input_path}")

    df = pd.read_csv(input_path).dropna(subset=FEATURES + [TARGET]).copy()
    df = df[(df["averageVolumeFraction"].between(0.0, 1.0))]
    df = df[(df["totalDurationMinutes"] > 0.0)]
    df[TARGET] = df[TARGET].clip(0.5, 2.0)
    if df.empty:
        raise ValueError("No valid rows in training data.")

    x = df[FEATURES].to_numpy(dtype=np.float32)
    y = df[TARGET].to_numpy(dtype=np.float32)

    x_train, x_val, y_train, y_val = train_test_split(
        x, y, test_size=0.2, random_state=args.seed
    )

    model = build_model(x_train)
    callbacks = [
        tf.keras.callbacks.EarlyStopping(
            monitor="val_loss",
            patience=8,
            restore_best_weights=True,
        )
    ]

    history = model.fit(
        x_train,
        y_train,
        validation_data=(x_val, y_val),
        epochs=args.epochs,
        batch_size=args.batch_size,
        callbacks=callbacks,
        verbose=2,
    )

    val_pred = model.predict(x_val, verbose=0).reshape(-1)
    val_mae = float(np.mean(np.abs(val_pred - y_val)))

    # Save Keras model.
    keras_path = output_dir / "risk_model.keras"
    model.save(keras_path)

    # Convert to TFLite.
    converter = tf.lite.TFLiteConverter.from_keras_model(model)
    converter.optimizations = [tf.lite.Optimize.DEFAULT]
    tflite_model = converter.convert()
    tflite_path = output_dir / "safesound_risk.tflite"
    tflite_path.write_bytes(tflite_model)

    checks = monotonic_check(model)
    metrics = {
        "rows": int(len(df)),
        "train_rows": int(len(x_train)),
        "val_rows": int(len(x_val)),
        "val_mae": val_mae,
        "best_val_loss": float(np.min(history.history["val_loss"])),
        "features": FEATURES,
        "target": TARGET,
        "output_range": [0.5, 2.0],
        "checks": checks,
    }
    (output_dir / "metrics.json").write_text(json.dumps(metrics, indent=2))

    print(f"Saved keras model: {keras_path}")
    print(f"Saved TFLite model: {tflite_path}")
    print(f"Saved metrics: {output_dir / 'metrics.json'}")
    print(json.dumps(metrics, indent=2))


if __name__ == "__main__":
    main()

