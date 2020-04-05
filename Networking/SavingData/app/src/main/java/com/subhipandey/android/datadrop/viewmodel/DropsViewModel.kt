
package com.subhipandey.android.datadrop.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.subhipandey.android.datadrop.app.Injection
import com.subhipandey.android.datadrop.model.Drop


class DropsViewModel(application: Application) : AndroidViewModel(application) {
  private val repository = Injection.provideDropRepository()
  private val allDrops = repository.getDrops()

  fun getDrops() = allDrops

  fun insert(drop: Drop) = repository.addDrop(drop)

  fun clearAllDrops() = repository.clearAllDrops()

  fun clearDrop(drop: Drop) = repository.clearDrop(drop)
}