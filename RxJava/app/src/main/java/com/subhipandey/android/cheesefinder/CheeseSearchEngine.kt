

package com.subhipandey.android.cheesefinder

import android.content.Context
import android.util.Log
import com.subhipandey.android.cheesefinder.database.Cheese
import com.subhipandey.android.cheesefinder.database.CheeseDatabase

class CheeseSearchEngine(private val context: Context) {

  fun search(query: String): List<Cheese>? {
    Thread.sleep(2000)
    Log.d("Searching", "Searching for $query")
    return CheeseDatabase.getInstance(context).cheeseDao().findCheese("%$query%")
  }

}