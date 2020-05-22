

package com.subhipandey.android.rwandroidtutorial

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.subhipandey.android.rwandroidtutorial.database.Player
import com.subhipandey.android.rwandroidtutorial.database.PlayerListItem
import com.subhipandey.android.rwandroidtutorial.database.PlayersDatabase

open class PlayerViewModel(application: Application) : AndroidViewModel(application) {

  private val repository: PlayerRepository

  init {
    val playerDao = PlayersDatabase
        .getDatabase(application)
        .playerDao()
    repository = PlayerRepository(playerDao)
  }

  fun populateDatabase() {
    val resources = getApplication<Application>().resources
    val jsonString = resources.openRawResource(R.raw.players).bufferedReader().use {
      it.readText()
    }
    val typeToken = object : TypeToken<List<Player>>() {}.type
    val tennisPlayers = Gson().fromJson<List<Player>>(jsonString, typeToken)
    repository.insertAllPlayers(tennisPlayers)
  }

  fun getAllPlayers(): List<PlayerListItem> {
    return repository.getAllPlayers()
  }
}