package com.subhipandey.android.subhipandey

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.subhipandey.android.subhipandey.database.Player
import com.subhipandey.android.subhipandey.database.PlayerListItem
import com.subhipandey.android.subhipandey.database.PlayersDatabase

open class PlayerViewModel(application: Application) : AndroidViewModel(application) {

  private val repository: PlayerRepository

  init {
    val playerDao = PlayersDatabase
            .getDatabase(application, viewModelScope, application.resources)
            .playerDao()
    repository = PlayerRepository(playerDao)
  }

  fun getAllPlayers(): LiveData<List<PlayerListItem>> {
    return repository.getAllPlayers()
  }
}