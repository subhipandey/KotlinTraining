package service

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.text.BoringLayout
import android.util.Log
import com.subhipandey.android.photosapp.app.PhotosUtils

class PhotosJobService : JobService() {

companion object{
    private const val TAG = "PhotosJobService"
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        val runnable = Runnable {
            val needsReschedule: Boolean
            needsReschedule = try {
                val jsonString = PhotosUtils.fetchJsonString()
                (jsonString == null)
            } catch (e: InterruptedException) {
                Log.e(TAG, "Error running job: " + e.message)
                true
            }
            Log.i(TAG, "Job Finished: ${params?.jobId}, needsReschedule = $needsReschedule ")
            jobFinished(params, needsReschedule)
        }

     Thread(runnable).start()
     return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i(TAG, "Job stopped" + params?.jobId)
        return false
    }
}
