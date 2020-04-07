

package com.subhipandey.android.photosapp.repository

import android.arch.lifecycle.LiveData


interface Repository {
  fun getPhotos(): LiveData<List<String>>
  fun getBanner(): LiveData<String>
}