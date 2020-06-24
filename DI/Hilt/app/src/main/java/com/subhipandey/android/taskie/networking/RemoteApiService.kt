package com.subhipandey.android.taskie.networking

import com.subhipandey.android.taskie.model.Task
import com.subhipandey.android.taskie.model.request.AddTaskRequest
import com.subhipandey.android.taskie.model.request.UserDataRequest
import com.subhipandey.android.taskie.model.response.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Holds the API calls for the Taskie app.
 */
interface RemoteApiService {

  @POST("/api/register")
  fun registerUser(@Body request: UserDataRequest): Call<RegisterResponse>

  @GET("/api/note")
  suspend fun getNotes(): GetTasksResponse

  @POST("/api/login")
  fun loginUser(@Body request: UserDataRequest): Call<LoginResponse>

  @GET("/api/user/profile")
  suspend fun getMyProfile(): UserProfileResponse

  @POST("/api/note/complete")
  suspend fun completeTask(@Query("id") noteId: String): CompleteNoteResponse

  @POST("/api/note")
  suspend fun addTask(@Body request: AddTaskRequest): Task

  @DELETE("/api/note")
  suspend fun deleteNote(@Query("id") noteId: String): DeleteNoteResponse
}