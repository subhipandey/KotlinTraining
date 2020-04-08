package workers
import android.util.Log
import androidx.work.Worker
import com.subhipandey.android.photouploader.ImageUtils


private const val LOG_TAG = "CleanFilesWorker"

class CleanFilesWorker : Worker() {

    override fun doWork(): WorkerResult = try {
        // Sleep for debugging purposes
        Thread.sleep(3000)
        Log.d(LOG_TAG, "Cleaning files!")

        ImageUtils.cleanFiles(applicationContext)

        Log.d(LOG_TAG, "Success!")
        WorkerResult.SUCCESS
    } catch (e: Throwable) {
        Log.e(LOG_TAG, "Error executing work: ${e.message}", e)
        WorkerResult.FAILURE
    }
}