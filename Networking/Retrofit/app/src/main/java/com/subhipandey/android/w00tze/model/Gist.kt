

package com.subhipandey.android.w00tze.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Gist(@SerializedName("created_at") val createdAt: Date, val description: String)