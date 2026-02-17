package com.safesound.app.ml

import android.content.Context
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class RiskModel(context: Context) {
    private val interpreter: Interpreter?

    init {
        interpreter = try {
            val model = loadModelFile(context, MODEL_FILE)
            Interpreter(model)
        } catch (_: Exception) {
            null
        }
    }

    data class RiskFeatures(
        val averageVolumeFraction: Double,
        val totalDurationMinutes: Double,
        val averageDb: Double,
        val dosePercent: Double
    )

    fun predictRiskPercent(features: RiskFeatures): Double {
        val clampedVolume = features.averageVolumeFraction.coerceIn(0.0, 1.0)
        val clampedDuration = features.totalDurationMinutes.coerceAtLeast(0.0)
        val clampedDb = features.averageDb.coerceIn(40.0, 120.0)
        val clampedDose = features.dosePercent.coerceAtLeast(0.0)

        val fallbackRisk = clampedDose.coerceIn(0.0, 200.0)
        val localInterpreter = interpreter ?: return fallbackRisk
        val input = arrayOf(
            floatArrayOf(
                clampedVolume.toFloat(),
                clampedDuration.toFloat(),
                clampedDb.toFloat(),
                clampedDose.toFloat()
            )
        )
        val output = Array(1) { FloatArray(1) }
        return try {
            localInterpreter.run(input, output)
            val raw = output[0][0].toDouble()
            when {
                raw.isNaN() || raw.isInfinite() -> fallbackRisk
                raw in 0.2..4.0 -> (clampedDose * raw).coerceIn(0.0, 200.0)
                raw in 0.0..200.0 -> raw
                else -> fallbackRisk
            }
        } catch (_: Exception) {
            fallbackRisk
        }
    }

    fun predictMultiplier(features: FloatArray): Float? {
        val localInterpreter = interpreter ?: return null
        val input = arrayOf(features)
        val output = Array(1) { FloatArray(1) }
        return try {
            localInterpreter.run(input, output)
            output[0][0].coerceIn(0.5f, 2.0f)
        } catch (_: Exception) {
            null
        }
    }

    private fun loadModelFile(context: Context, fileName: String): MappedByteBuffer {
        val assetFile = context.assets.openFd(fileName)
        FileInputStream(assetFile.fileDescriptor).use { inputStream ->
            val fileChannel = inputStream.channel
            return fileChannel.map(
                FileChannel.MapMode.READ_ONLY,
                assetFile.startOffset,
                assetFile.declaredLength
            )
        }
    }

    companion object {
        const val MODEL_FILE = "safesound_risk.tflite"
    }
}
