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
