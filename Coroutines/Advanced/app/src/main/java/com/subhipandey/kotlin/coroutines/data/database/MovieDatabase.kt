
package com.subhipandey.kotlin.coroutines.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.subhipandey.kotlin.coroutines.data.model.Movie



@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

  abstract fun movieDao(): MovieDao

  companion object {

    fun create(context: Context): MovieDatabase {

      return Room.databaseBuilder(
          context,
          MovieDatabase::class.java,
          "movies"
      )
          .allowMainThreadQueries()
          .build()
    }
  }
}