

package com.subhipandey.android.photosapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.AsyncTask
import android.support.v4.content.LocalBroadcastManager
import androidx.work.*
import com.subhipandey.android.photosapp.app.photosappApplication
import com.subhipandey.android.photosapp.app.PhotosUtils
import com.subhipandey.android.photosapp.service.DownloadWorker
import com.subhipandey.android.photosapp.service.FetchIntentService
import java.util.concurrent.TimeUnit


class PhotosRepository : Repository {

  companion object {
    const val DOWNLOAD_WORK_TAG = "DOWNLOAD_WORK_TAG"
  }

  private val photosLiveData = MutableLiveData<List<String>>()
  private val bannerLiveData = MutableLiveData<String>()

  init {
    schedulePeriodicWorkRequest()
  }

  private val receiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      FetchBannerAsyncTask({ banner ->
        bannerLiveData.value = banner
      }).execute()
      FetchPhotosAsyncTask({ photos ->
        photosLiveData.value = photos
      }).execute()
    }
  }

  override fun register() {
    LocalBroadcastManager.getInstance(photosappApplication.getAppContext())
        .registerReceiver(receiver, IntentFilter(FetchIntentService.FETCH_COMPLETE))
  }

  override fun unregister() {
    LocalBroadcastManager.getInstance(photosappApplication.getAppContext())
        .unregisterReceiver(receiver)
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

  private fun schedulePeriodicWorkRequest() {
    val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresStorageNotLow(true)
        .build()

    val workManager = WorkManager.getInstance()

    val request: WorkRequest = PeriodicWorkRequestBuilder<DownloadWorker>(15, TimeUnit.MINUTES)
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