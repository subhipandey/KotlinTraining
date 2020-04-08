package workers

import android.net.Uri
import android.util.Log
import androidx.work.Worker
import com.subhipandey.android.photouploader.ImageUtils

private const val LOG_TAG = "UploadWorker"
private const val KEY_ZIP_PATH = "ZIP_PATH"

class UploadWorker : Worker() {

    override fun doWork(): WorkerResult = try {
        // Sleep for debugging purposes
        Thread.sleep(3000)
        Log.d(LOG_TAG, "Uploading file!")

        val zipPath = inputData.getString(KEY_ZIP_PATH, null)

        ImageUtils.uploadFile(Uri.parse(zipPath))

        Log.d(LOG_TAG, "Success!")
        WorkerResult.SUCCESS
    } catch (e: Throwable) {
        Log.e(LOG_TAG, "Error executing work: " + e.message, e)
        WorkerResult.FAILURE
    }
}