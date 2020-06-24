

package com.subhipandey.android.taskie.model.response

import com.subhipandey.android.taskie.model.Task
import kotlinx.serialization.Serializable

@Serializable
data class GetTasksResponse(val notes: List<Task> = listOf())