

package com.subhipandey.android.creatures.model

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Favorites {

  private val KEY_FAVORITES = "KEY_FAVORITES"
  private val gson = Gson()

  private var favorites: MutableList<Int>? = null

  fun isFavorite(creature: Creature, context: Context): Boolean {
    return getFavorites(context)?.contains(creature.id) == true
  }

  fun addFavorite(creature: Creature, context: Context) {
    val favorites = getFavorites(context)
    favorites?.let {
      creature.isFavorite = true
      favorites.add(creature.id)
      saveFavorites(KEY_FAVORITES, favorites, context)
    }
  }

  fun removeFavorite(creature: Creature, context: Context) {
    val favorites = getFavorites(context)
    favorites?.let {
      creature.isFavorite = false
      favorites.remove(creature.id)
      saveFavorites(KEY_FAVORITES, favorites, context)
    }
  }

   fun getFavorites(context: Context): MutableList<Int>? {
    if (favorites == null) {
      val json = sharedPrefs(context).getString(KEY_FAVORITES, "")
      val type = object : TypeToken<MutableList<Int>>() {}.type
      favorites = gson.fromJson<MutableList<Int>>(json, type) ?: return mutableListOf()
    }
    return favorites
  }

  private fun saveFavorites(key: String, list: List<Int>, context: Context) {
    val json = gson.toJson(list)
    sharedPrefs(context).edit().putString(key, json).apply()
  }

  private fun sharedPrefs(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)
}