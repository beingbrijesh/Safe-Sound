package com.safesound.app.data.repo

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.safesound.app.BuildConfig
import com.safesound.app.data.model.PlaybackInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "safesound_settings")

class SettingsRepository(private val context: Context) {
    private val dataStore = context.dataStore

    private val firstSyncDoneKey = booleanPreferencesKey("first_sync_done")
    private val backendUrlKey = stringPreferencesKey("backend_url")
    private val lastSyncStatusKey = stringPreferencesKey("last_sync_status")
    private val autoStartEnabledKey = booleanPreferencesKey("auto_start_enabled")
    private val batteryCardDismissedKey = booleanPreferencesKey("battery_card_dismissed")
    private val playbackActiveKey = booleanPreferencesKey("playback_active")
    private val playbackContentTypeKey = stringPreferencesKey("playback_content_type")
    private val playbackSourceAppKey = stringPreferencesKey("playback_source_app")
    private val playbackSourcePackageKey = stringPreferencesKey("playback_source_package")

    fun observeLastSyncStatus(): Flow<String> {
        return dataStore.data.map { prefs ->
            prefs[lastSyncStatusKey] ?: "Not synced yet"
        }
    }

    suspend fun setLastSyncStatus(status: String) {
        dataStore.edit { prefs ->
            prefs[lastSyncStatusKey] = status
        }
    }

    fun observeAutoStartEnabled(): Flow<Boolean> {
        return dataStore.data.map { prefs ->
            prefs[autoStartEnabledKey] ?: true
        }
    }

    suspend fun setAutoStartEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[autoStartEnabledKey] = enabled
        }
    }

    fun observeBatteryCardDismissed(): Flow<Boolean> {
        return dataStore.data.map { prefs ->
            prefs[batteryCardDismissedKey] ?: false
        }
    }

    suspend fun setBatteryCardDismissed(dismissed: Boolean) {
        dataStore.edit { prefs ->
            prefs[batteryCardDismissedKey] = dismissed
        }
    }

    fun observePlaybackInfo(): Flow<PlaybackInfo> {
        return dataStore.data.map { prefs ->
            PlaybackInfo(
                active = prefs[playbackActiveKey] ?: false,
                contentType = prefs[playbackContentTypeKey],
                sourceApp = prefs[playbackSourceAppKey],
                sourcePackage = prefs[playbackSourcePackageKey]
            )
        }
    }

    suspend fun setPlaybackInfo(info: PlaybackInfo) {
        dataStore.edit { prefs ->
            prefs[playbackActiveKey] = info.active
            if (info.contentType == null) {
                prefs.remove(playbackContentTypeKey)
            } else {
                prefs[playbackContentTypeKey] = info.contentType
            }
            if (info.sourceApp == null) {
                prefs.remove(playbackSourceAppKey)
            } else {
                prefs[playbackSourceAppKey] = info.sourceApp
            }
            if (info.sourcePackage == null) {
                prefs.remove(playbackSourcePackageKey)
            } else {
                prefs[playbackSourcePackageKey] = info.sourcePackage
            }
        }
    }

    suspend fun isFirstSyncDone(): Boolean {
        return dataStore.data.first()[firstSyncDoneKey] ?: false
    }

    suspend fun setFirstSyncDone(value: Boolean) {
        dataStore.edit { prefs ->
            prefs[firstSyncDoneKey] = value
        }
    }

    suspend fun getBackendUrl(): String {
        return dataStore.data.first()[backendUrlKey] ?: BuildConfig.SPEC_BACKEND_URL
    }

    suspend fun setBackendUrl(url: String) {
        dataStore.edit { prefs ->
            prefs[backendUrlKey] = url
        }
    }
}
