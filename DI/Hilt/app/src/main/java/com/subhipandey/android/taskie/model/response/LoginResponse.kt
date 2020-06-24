

package com.subhipandey.android.taskie.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(val token: String? = "")