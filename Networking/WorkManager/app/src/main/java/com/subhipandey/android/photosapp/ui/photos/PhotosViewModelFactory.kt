
package com.subhipandey.android.photosapp.ui.photos

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.subhipandey.android.photosapp.repository.Repository


class PhotosViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(PhotosViewModel::class.java)) {
      return PhotosViewModel(repository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}