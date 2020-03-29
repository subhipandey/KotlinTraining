

package com.subhipandey.android.creatures.model


data class Food(val id: Int, val name: String, val image: String) {
    val thumbnail: String
    get() = "drawable/thumbnail_$image"
}