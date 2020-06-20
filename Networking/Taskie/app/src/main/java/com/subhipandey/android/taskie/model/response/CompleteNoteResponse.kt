package com.subhipandey.android.taskie.model.response

import com.google.gson.annotations.SerializedName


/**
 * Holds a message response after a note is completed.
 */

@Serializable
class CompleteNoteResponse(val message: String?)