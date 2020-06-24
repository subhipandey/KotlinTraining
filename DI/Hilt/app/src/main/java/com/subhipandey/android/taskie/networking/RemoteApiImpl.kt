

package com.subhipandey.android.taskie.networking

import com.subhipandey.android.taskie.model.*
import com.subhipandey.android.taskie.model.request.AddTaskRequest
import com.subhipandey.android.taskie.model.request.UserDataRequest
import com.subhipandey.android.taskie.model.response.LoginResponse
import com.subhipandey.android.taskie.model.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Holds decoupled logic for all the API calls.
 */

class RemoteApiImpl @Inject constructor(
        private val apiService: RemoteApiService) : RemoteApi {

  override fun loginUser(userDataRequest: UserDataRequest, onUserLoggedIn: (Result<String>) -> Unit) {
    apiService.loginUser(userDataRequest).enqueue(object : Callback<LoginResponse> {
      override fun onFailure(call: Call<LoginResponse>, error: Throwable) {
        onUserLoggedIn(Failure(error))
      }

      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        val loginResponse = response.body()

        if (loginResponse == null || loginResponse.token.isNullOrEmpty()) {
          onUserLoggedIn(Failure(NullPointerException("No response body!")))
        } else {
          onUserLoggedIn(Success(loginResponse.token))
        }
      }
    })
  }

  override fun registerUser(userDataRequest: UserDataRequest, onUserCreated: (Result<String>) -> Unit) {
    apiService.registerUser(userDataRequest).enqueue(object : Callback<RegisterResponse> {
      override fun onFailure(call: Call<RegisterResponse>, error: Throwable) {
        onUserCreated(Failure(error))
      }

      override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
        val message = response.body()?.message
        if (message == null) {
          onUserCreated(Failure(NullPointerException("No response body!")))
          return
        }

        onUserCreated(Success(message))
      }
    })
  }

  override suspend fun getTasks(): Result<List<Task>> = try {
    val data = apiService.getNotes().notes

    Success(data.filter { !it.isCompleted })
  } catch (error: Throwable) {
    Failure(error)
  }

  override suspend fun deleteTask(taskId: String) = try {
    val data = apiService.deleteNote(taskId)

    Success(data.message)
  } catch (error: Throwable) {
    Failure(error)
  }

  override suspend fun completeTask(taskId: String): Result<String> = try {
    val response = apiService.completeTask(taskId)

    Success(response.message!!)
  } catch (error: Throwable) {
    Failure(error)
  }

  override suspend fun addTask(addTaskRequest: AddTaskRequest): Result<Task> = try {
    val task = apiService.addTask(addTaskRequest)

    Success(task)
  } catch (error: Throwable) {
    Failure(error)
  }


  override suspend fun getUserProfile(): Result<UserProfile> = try {
    val notesResult = getTasks()

    if (notesResult is Failure) {
      Failure(notesResult.error)
    } else {
      val notes = notesResult as Success
      val data = apiService.getMyProfile()

      if (data.name == null || data.email == null) {
        Failure(NullPointerException("No data available!"))
      } else {
        Success(UserProfile(data.email, data.name, notes.data.size))
      }
    }
  } catch (error: Throwable) {
    Failure(error)
  }
}