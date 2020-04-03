

package com.subhipandey.android.datadrop.model


object InMemoryRepository : DropRepository {

  private val drops = HashMap<String, Drop>()

  override fun addDrop(drop: Drop) {
    drops[drop.id] = drop
  }

  override fun getDrops(): List<Drop> {
    return drops.values.toList()
  }

  override fun clearDrop(drop: Drop) {
    drops.remove(drop.id)
  }

  override fun clearAllDrops() {
    drops.clear()
  }
}