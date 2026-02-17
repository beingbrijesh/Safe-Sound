package com.safesound.app.network

import com.safesound.app.data.repo.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.net.URLEncoder

class SpecRemoteClient(
    val settingsRepository: SettingsRepository,
    private val client: OkHttpClient = OkHttpClient()
) {
    suspend fun lookup(query: String): SpecResult? = withContext(Dispatchers.IO) {
        if (query.isBlank()) return@withContext null
        val baseUrl = settingsRepository.getBackendUrl().trimEnd('/')
        val url = "$baseUrl/specs?query=${URLEncoder.encode(query, "UTF-8")}"
        val request = Request.Builder().url(url).get().build()
        return@withContext try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return@use null
                val body = response.body?.string() ?: return@use null
                parseSpec(JSONObject(body))
            }
        } catch (_: Exception) {
            null
        }
    }

    private fun parseSpec(json: JSONObject): SpecResult {
        fun stringOrNull(key: String): String? {
            val value = json.optString(key, "")
            return value.takeIf { it.isNotBlank() }
        }

        return SpecResult(
            brand = stringOrNull("brand"),
            model = stringOrNull("model"),
            driverSizeMm = json.optDouble("driverSizeMm").takeIf { !it.isNaN() },
            frequencyLowHz = json.optInt("frequencyLowHz").takeIf { it != 0 },
            frequencyHighHz = json.optInt("frequencyHighHz").takeIf { it != 0 },
            impedanceOhm = json.optDouble("impedanceOhm").takeIf { !it.isNaN() },
            sensitivityDb = json.optDouble("sensitivityDb").takeIf { !it.isNaN() },
            powerMw = json.optDouble("powerMw").takeIf { !it.isNaN() },
            sourceName = stringOrNull("sourceName"),
            sourceUrl = stringOrNull("sourceUrl"),
            verified = json.optBoolean("verified", false)
        )
    }
}
