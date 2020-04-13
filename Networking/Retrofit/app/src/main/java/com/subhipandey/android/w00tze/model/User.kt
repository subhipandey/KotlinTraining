

package com.subhipandey.android.w00tze.model

import com.google.gson.annotations.SerializedName


data class User(
    val id: Long,
    val name: String,
    val login: String,
    val company: String,
    @SerializedName("avatar_url") val avatarUrl: String)