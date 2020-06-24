package com.subhipandey.android.taskie.networking

import com.subhipandey.android.taskie.model.Result
import com.subhipandey.android.taskie.model.Task
import com.subhipandey.android.taskie.model.UserProfile
import com.subhipandey.android.taskie.model.request.AddTaskRequest
import com.subhipandey.android.taskie.model.request.UserDataRequest

interface RemoteApi {

  fun loginUser(userDataRequest: UserDataRequest, onUserLoggedIn: (Result<String>) -> Unit)

  fun registerUser(userDataRequest: UserDataRequest, onUserCreated: (Result<String>) -> Unit)

  suspend fun getTasks(): Result<List<Task>>

  suspend fun deleteTask(taskId: String): Result<String>

  suspend fun completeTask(taskId: String): Result<String>

  suspend fun addTask(addTaskRequest: AddTaskRequest): Result<Task>

  suspend fun getUserProfile(): Result<UserProfile>
}
