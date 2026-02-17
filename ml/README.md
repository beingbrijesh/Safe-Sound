# SafeSound ML Pretraining (Public Data First)

This folder contains a low-complication pretraining pipeline:

1. Build a public device pool.
2. Generate synthetic WHO/H.870-based training rows.
3. Train a compact multiplier model and export TFLite.
4. Copy TFLite to Android assets.

## 1) Environment

```bash
cd "/Users/beingbrijesh/Documents/New project"
python3 -m venv ml/.venv
source ml/.venv/bin/activate
pip install --upgrade pip
pip install pandas numpy scikit-learn tensorflow-macos tensorflow-metal pyarrow
```

For Google Colab use:

```bash
pip install -q -r ml/requirements-colab.txt
```

## 2) Public source download (optional but recommended)

```bash
mkdir -p ml/public
git clone --depth 1 https://github.com/jaakkopasanen/AutoEq.git ml/public/AutoEq
```

If AutoEq is missing, the pipeline still runs from your backend catalogs.

## 3) Build device pool

```bash
python ml/scripts/build_device_pool.py
```

Output:
- `ml/data/device_pool.csv`

## 4) Generate synthetic pretraining rows

```bash
python ml/scripts/generate_pretrain_data.py --rows 300000
```

Output:
- `ml/data/pretrain_dataset.csv`

Feature order (must stay fixed):
1. `averageVolumeFraction`
2. `totalDurationMinutes`
3. `averageDb`
4. `dosePercent`

## 5) Train model + export TFLite

```bash
python ml/scripts/train_model.py --epochs 80 --batch-size 256
```

Outputs:
- `ml/models/risk_model.keras`
- `ml/models/safesound_risk.tflite`
- `ml/models/metrics.json`

## 6) Place model in Android app

```bash
mkdir -p app/src/main/assets
cp ml/models/safesound_risk.tflite app/src/main/assets/safesound_risk.tflite
```

## 7) Build and install app

```bash
./gradlew :app:installDebug
```

## Notes

- This model predicts a **risk multiplier** in `[0.5, 2.0]`.
- App final risk is computed from deterministic dose + ML multiplier.
- When real user data is available, fine-tune with real labels and keep WHO/H.870 dosimetry as baseline.
