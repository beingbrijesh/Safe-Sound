package com.safesound.app.data.model

data class PlaybackInfo(
    val active: Boolean,
    val contentType: String?,
    val sourceApp: String?,
    val sourcePackage: String?
) {
    companion object {
        fun inactive() = PlaybackInfo(false, null, null, null)
    }
}
