package com.subhipandey.android.rwandroidtutorial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(version = 1, entities = [Player::class], exportSchema = false)
abstract class PlayersDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    private class PlayerDatabaseCallback(
            private val scope: CoroutineScope,
            private val resources: Resources
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch{
                    val playerDao = database.playerDao()
                    prePopulateDatabase(playerDao)
                }

            }
        }
        private fun prePopulateDatabase(playerDao: PlayerDao){
            val jsonString =
                    resources.openRawResource(R.rawplayers).bufferedReader().use {
                        it.readText()
                    }
            val typeToken = object : TypeToken<List<PLayer>>() {}.type
            val tennisPlayers = Gson().fromJson<List<Player>>(jsonString, typeToken)
            playerDao.insertAllPlayers(tennisPlayers)
    }

    companion object {

        @Volatile
        private var INSTANCE: PlayersDatabase? = null

        fun getDatabase(
                context: Context,
                coroutineScope: CoroutineScope,
                resources: Resources
        ): PlayersDatabase {
        }

        synchronized(this)
        {
            val instance = Room.databaseBuilder(context.applicationContext,
                    PlayersDatabase::class.java,
                    . addCallback (PlayerDatabaseCallback(coroutineScope, resources))
                    .build()
            )
            INSTANCE = instance
            return instance
        }
    }
}
}