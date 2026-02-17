# SafeSound

SafeSound is an Android 10+ app that monitors headphone listening exposure, estimates hearing risk using WHO-style dose calculations, and caches official earphone specs for offline use. All user data stays on device. The hybrid spec lookup model only uses the backend to fetch official manufacturer data when a device spec is missing locally.

## Project Layout
- `app/` Android app (Kotlin + Compose)
- `backend/` minimal Node service to fetch official specs

## Android App
### Features
- Foreground monitoring service that tracks headphone usage and listening exposure.
- Global playback detection (music/video/apps) via AudioPlaybackCallback.
- Auto-start monitoring on boot/headphone connect (toggle in UI).
- WHO-style dose calculation to estimate risk %.
- Optional lightweight on-device ML refinement via TFLite.
- Offline-first spec cache stored in Room.
- First-run sync that fetches specs for bonded Bluetooth devices.
- 7-day detailed history retention; older sessions are compacted to timing + volume only.

### Setup
1. Open the project in Android Studio.
2. Ensure Android Gradle Plugin and Kotlin versions are compatible with your Studio install.
3. Add your TFLite model at `app/src/main/assets/safesound_risk.tflite` (optional).
4. Update the backend URL in `app/build.gradle.kts` (`SPEC_BACKEND_URL`).

### Notes
- `android:usesCleartextTraffic="true"` is enabled for local development. Disable it for production.
- Bluetooth device names are used as lookup keys; an exact name match is best.
- Volume-to-dB estimation is approximate; calibration UI can be added later.

### Key Files
- `app/src/main/java/com/safesound/app/monitor/ListeningMonitor.kt`
- `app/src/main/java/com/safesound/app/network/SpecSyncWorker.kt`
- `app/src/main/java/com/safesound/app/data/repo/SpecRepository.kt`

## Backend (Hybrid Spec Lookup)
The backend is a simple service that should only fetch specs from official manufacturer pages. The starter code provides stubs and an allowlist file.

### Setup
1. `cd backend`
2. `npm install`
3. `npm run dev`

### Important
- Populate `backend/data/official_domains.json` with official manufacturer domains.
- Implement `fetchOfficialSpecs` in `backend/src/sources/officialFetcher.ts`.

## Notes
- On-device spec cache is used first, then the backend is queried on misses.
- All listening analytics remain on device.
