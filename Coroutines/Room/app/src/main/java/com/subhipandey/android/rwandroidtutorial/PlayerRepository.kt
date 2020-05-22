

package com.subhipandey.android.rwandroidtutorial

import com.subhipandey.android.rwandroidtutorial.database.Player
import com.subhipandey.android.rwandroidtutorial.database.PlayerDao
import com.subhipandey.android.rwandroidtutorial.database.PlayerListItem

class PlayerRepository(private val playerDao: PlayerDao) {

  fun getAllPlayers(): List<PlayerListItem> {
    return playerDao.getAllPlayers()
  }

  fun insertAllPlayers(players: List<Player>) {
    playerDao.insertAllPlayers(players)
  }
}