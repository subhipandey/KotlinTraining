package workers

import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import com.subhipandey.android.photouploader.ImageUtils

private const val LOG_TAG = "CompressWorker"
private const val KEY_IMAGE_PATH = "IMAGE_PATH"
private const val KEY_ZIP_PATH = "ZIP_PATH"

class CompressWorker : Worker() {

    override fun doWork(): WorkerResult = try {
        // Sleep for debugging purposes
        Thread.sleep(3000)
        Log.d(LOG_TAG, "Compressing files!")

        val imagePaths = inputData.keyValueMap
                .filter { it.key.startsWith(KEY_IMAGE_PATH) }
                .map { it.value as String }

        val zipFile = ImageUtils.createZipFile(applicationContext, imagePaths.toTypedArray())

        outputData = Data.Builder()
                .putString(KEY_ZIP_PATH, zipFile.path)
                .build()

        Log.d(LOG_TAG, "Success!")
        WorkerResult.SUCCESS
    } catch (e: Throwable) {
        Log.e(LOG_TAG, "Error executing work: " + e.message, e)
        WorkerResult.FAILURE
    }
}