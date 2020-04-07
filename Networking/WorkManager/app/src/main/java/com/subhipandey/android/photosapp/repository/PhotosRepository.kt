

package com.subhipandey.android.photosapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask
import com.subhipandey.android.photosapp.app.PhotosUtils


class PhotosRepository : Repository {
    private val photosLiveData = MutableLiveData<List<String>>()
    private val bannerLiveData = MutableLiveData<String>()

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