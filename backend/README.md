# SafeSound Spec Backend

This service fetches earphone specs from official manufacturer sources only. It is designed as a thin proxy so the Android app can stay offline-first and privacy focused.

## Setup
1. `npm install`
2. `npm run dev`

## How It Works
- `/specs?query=...` accepts a device query string.
- `fetchOfficialSpecs` should search official pages and extract fields.
- `data/official_domains.json` defines the allowlist.

## TODO
- Implement manufacturer adapters and HTML parsing.
- Add caching to reduce repeated fetches.
