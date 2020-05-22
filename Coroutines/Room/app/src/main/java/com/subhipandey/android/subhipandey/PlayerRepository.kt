

package com.subhipandey.android.subhipandey

import androidx.lifecycle.LiveData
import com.subhipandey.android.subhipandey.database.Player
import com.subhipandey.android.subhipandey.database.PlayerDao
import com.subhipandey.android.subhipandey.database.PlayerListItem

class PlayerRepository(private val playerDao: PlayerDao) {

  fun getAllPlayers(): LiveData<List<PlayerListItem>> {
    return playerDao.getAllPlayers()
  }

  fun getPlayer(id: Int): LiveData<Player> {
    return playerDao.getPlayer(id)
  }




}