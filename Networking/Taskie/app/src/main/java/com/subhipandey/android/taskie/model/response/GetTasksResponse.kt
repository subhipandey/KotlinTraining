

package com.subhipandey.android.taskie.model.response

import com.subhipandey.android.taskie.model.Task

data class GetTasksResponse(val notes: List<Task> = mutableListOf())