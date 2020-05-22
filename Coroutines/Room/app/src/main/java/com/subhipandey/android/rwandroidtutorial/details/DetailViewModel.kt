

package com.subhipandey.android.rwandroidtutorial.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.subhipandey.android.rwandroidtutorial.PlayerRepository
import com.subhipandey.android.rwandroidtutorial.database.PlayersDatabase

class DetailViewModel(application: Application) : AndroidViewModel(application) {

  private val repository: PlayerRepository

  init {
    val playerDao = PlayersDatabase
        .getDatabase(application)
        .playerDao()
    repository = PlayerRepository(playerDao)
  }
}