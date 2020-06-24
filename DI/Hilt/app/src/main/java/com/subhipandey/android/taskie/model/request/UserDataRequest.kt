

package com.subhipandey.android.taskie.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UserDataRequest(
  val email: String,
  val password: String,
  val name: String? = null
)