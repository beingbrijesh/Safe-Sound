package com.safesound.app.util

object DeviceNameParser {
    private val noiseTokens = listOf("bluetooth", "headset", "earbuds", "wireless", "handsfree")

    fun normalize(name: String): String {
        return name.trim().replace(Regex("\\s+"), " ")
    }

    fun buildQuery(name: String): String {
        var query = normalize(name)
        if (query.startsWith("LE-")) {
            query = query.removePrefix("LE-")
        }
        query = query.replace(Regex("\\(.*?\\)"), "").trim()
        noiseTokens.forEach { token ->
            query = query.replace(Regex("\\b${token}\\b", RegexOption.IGNORE_CASE), "").trim()
        }
        return query
    }
}
