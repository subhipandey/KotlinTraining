

package com.subhipandey.android.taskie.model.response

import kotlinx.serialization.Serializable

/**
 * Holds the user data, to display on the profile screen.
 */

@Serializable
class UserProfileResponse(
  val email: String?,
  val name: String?)