

package com.subhipandey.android.photosapp.ui.photos

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.subhipandey.android.photosapp.repository.Repository


class PhotosViewModel(private val repository: Repository) : ViewModel() {

  fun getPhotos(): LiveData<List<String>> {
    return repository.getPhotos()
  }

  fun getBanner(): LiveData<String> {
    return repository.getBanner()
  }
}

