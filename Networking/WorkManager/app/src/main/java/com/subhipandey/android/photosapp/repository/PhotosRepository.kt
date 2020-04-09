

package com.subhipandey.android.photosapp.repository

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.ComponentName
import android.content.Context
import android.os.AsyncTask
import androidx.work.*
import com.subhipandey.android.photosapp.app.Constants
import com.subhipandey.android.photosapp.app.PhotosUtils
import com.subhipandey.android.photosapp.app.photosApplication
import service.DownloadWorker
import service.LogJobService
import service.PhotosJobService
import java.util.concurrent.TimeUnit


class PhotosRepository : Repository {
    private val photosLiveData = MutableLiveData<List<String>>()
    private val bannerLiveData = MutableLiveData<String>()

    companion object{
        const val DOWNLOAD_WORK_TAG = "DOWNLOAD_WORK_TAG"
    }

    init {
        schedulePeriodicWorkerRequest()
    }



    override fun getPhotos(): LiveData<List<String>> {
        FetchPhotosAsyncTask({ photos ->
            photosLiveData.value = photos
        }).execute()
        return photosLiveData
    }

    override fun getBanner(): LiveData<String> {
        FetchBannerAsyncTask({ banner ->
            bannerLiveData.value = banner
        }).execute()
        return bannerLiveData
    }

    private fun schedulePeriodicWorkerRequest() {
        val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

        val workManager = WorkManager.getInstance()
        val request: WorkRequest = PeriodicWorkRequestBuilder<DownloadWorker>(15,
        TimeUnit.MINUTES)
                .setConstraints(constraints)
                .addTag(DOWNLOAD_WORK_TAG)
                .build()
        workManager.cancelAllWorkByTag(DOWNLOAD_WORK_TAG)
        workManager.enqueue(request)
    }


    private class FetchBannerAsyncTask(val callback: (String) -> Unit)
        : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void): String? {
            val photosString = PhotosUtils.photoJsonString()
            return PhotosUtils.bannerFromJsonString(photosString ?: "")
        }

        override fun onPostExecute(result: String?) {
            if (result != null) {
                callback(result)
            }
        }
    }

    private class FetchPhotosAsyncTask(val callback: (List<String>) -> Unit)
        : AsyncTask<Void, Void, List<String>>() {
        override fun doInBackground(vararg params: Void): List<String>? {
            val photosString = PhotosUtils.photoJsonString()
            return PhotosUtils.photoUrlsFromJsonString(photosString ?: "")
        }

        override fun onPostExecute(result: List<String>?) {
            if (result != null) {
                callback(result)
            }
        }
    }
}