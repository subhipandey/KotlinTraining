
package com.subhipandey.android.octomembers.model

import com.google.gson.annotations.SerializedName


data class Member(
  val name: String,
  val login: String,
  val company: String,
  val email: String,
  val type: String,
  @SerializedName("avatar_url") val avatarUrl: String,
  @SerializedName("public_repos") val publicRepos: Int)
