

package com.subhipandey.android.subhipandey

import com.subhipandey.android.subhipandey.database.Player
import com.subhipandey.android.subhipandey.database.PlayerDao
import com.subhipandey.android.subhipandey.database.PlayerListItem

class PlayerRepository(private val playerDao: PlayerDao) {

  fun getAllPlayers(): List<PlayerListItem> {
    return playerDao.getAllPlayers()
  }


}