# SafeSound Spec Backend

This service resolves earphone specs using a priority trust chain and returns a normalized payload for the Android app.

Priority order:
1. Official manufacturer catalog.
2. Croma catalog for missing fields.
3. Trusted third-party catalog for remaining missing fields (domain + trust score gated).

## Setup
1. `npm install`
2. `npm run dev`

## How It Works
- `/specs?query=...` accepts a device query string.
- Matching is token-based with confidence thresholds to reduce false positives.
- Fields are merged in priority order: official -> croma -> trusted fallback.
- Trusted fallback records are accepted only when:
  - `sourceUrl` domain is listed in `data/trusted_domains.json`
  - `trustScore >= 0.75`

Data files:
- `data/spec_catalog.json`: official catalog.
- `data/spec_catalog_croma.json`: croma catalog.
- `data/spec_catalog_trusted.json`: trusted fallback catalog.
- `data/official_domains.json`: official domain allowlist.
- `data/trusted_domains.json`: trusted non-official domain allowlist.
- `data/spec_cache.sqlite`: persistent lookup cache DB (created automatically).

## Persistent cache DB
- Engine: SQLite (`better-sqlite3`).
- Table: `spec_cache`.
- Cache key: normalized query string.
- Default TTL: 30 days.
- Override TTL with env var:
  - `SPEC_CACHE_TTL_DAYS=15`
- Render note: mount a persistent disk and set service working directory under that mount if you want cache to survive restarts/redeploys.

## Adding data
1. Add/update official records in `data/spec_catalog.json`.
2. Add Croma records in `data/spec_catalog_croma.json`.
3. Add fallback records in `data/spec_catalog_trusted.json` with `trustScore`.
4. Ensure fallback domains exist in `data/trusted_domains.json`.
