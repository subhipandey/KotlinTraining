package service

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class LogJobService : JobService() {

    companion object{
        private const val TAG = "LogJobService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "OnCreate")
    }

    override fun onDestroy() {
        Log.i(TAG, "OnDestroy")
        super.onDestroy()
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        val runnable = Runnable{
            Thread.sleep(10000)
            jobFinished(params, false)
            Log.i(TAG, "Job Finished" + params?.jobId)
        }
        Log.i(TAG, "Starting Job:" + params?.jobId)
        Thread(runnable).start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i(TAG, "Stopping Job:" + params?.jobId)
        return false
    }
}
