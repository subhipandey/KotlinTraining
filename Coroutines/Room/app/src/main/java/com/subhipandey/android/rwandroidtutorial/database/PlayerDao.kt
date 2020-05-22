

package com.subhipandey.android.rwandroidtutorial.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insertAllPlayers(players: List<Player>)

  @Query("SELECT id, firstName, lastName, country, favorite, imageUrl FROM players")
  fun getAllPlayers(): List<PlayerListItem>
}