

package com.subhipandey.android.subhipandey.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insertAllPlayers(players: List<Player>)

  @Query("SELECT id, firstName, lastName, country, favorite, imageUrl FROM players")
  fun getAllPlayers(): LiveData<List<PlayerListItem>>

  @Query("SELECT * FROM players WHERE id = :id")
  fun getPlayer(id: Int): LiveData<Player>

    @Update
    suspend fun updatePlayer(player: Player)

  @Delete
  suspend fun deletePlayer(player: Player)





  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertAllPlayers(players: List<Player>)

}