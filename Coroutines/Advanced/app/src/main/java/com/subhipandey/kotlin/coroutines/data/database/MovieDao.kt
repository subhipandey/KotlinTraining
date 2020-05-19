
package com.subhipandey.kotlin.coroutines.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subhipandey.kotlin.coroutines.data.model.Movie



@Dao
interface MovieDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveMovies(movies: List<Movie>)

  @Query("SELECT * FROM movies")
  fun getSavedMovies(): List<Movie>
}