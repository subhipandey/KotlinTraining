package workers

import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import com.subhipandey.android.photouploader.ImageUtils

private const val LOG_TAG = "FilterWorker"
const val KEY_IMAGE_URI = "IMAGE_URI"
const val KEY_IMAGE_INDEX = "IMAGE_INDEX"

private const val IMAGE_PATH_PREFIX = "IMAGE_PATH_"

class FilterWorker : Worker() {

    override fun doWork(): WorkerResult = try {
        // Sleep for debugging purposes
        Thread.sleep(3000)
        Log.d(LOG_TAG, "Applying filter to image!")

        val imageUriString = inputData.getString(KEY_IMAGE_URI, null)
        val imageIndex = inputData.getInt(KEY_IMAGE_INDEX, 0)

        val bitmap = MediaStore.Images.Media.getBitmap(applicationContext.contentResolver, Uri.parse(imageUriString))

        val filteredBitmap = ImageUtils.applySepiaFilter(bitmap)
        val filteredImageUri = ImageUtils.writeBitmapToFile(applicationContext, filteredBitmap)

        outputData =
                Data.Builder()
                        .putString(IMAGE_PATH_PREFIX + imageIndex, filteredImageUri.toString())
                        .build()

        Log.d(LOG_TAG, "Success!")
        WorkerResult.SUCCESS
    } catch (e: Throwable) {
        Log.e(LOG_TAG, "Error executing work: " + e.message, e)
        WorkerResult.FAILURE
    }
}