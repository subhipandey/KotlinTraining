package com.subhipandey.android.taskie.networking

import com.subhipandey.android.taskie.model.Task
import com.subhipandey.android.taskie.model.UserProfile
import com.subhipandey.android.taskie.model.request.AddTaskRequest
import com.subhipandey.android.taskie.model.request.UserDataRequest
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

/**
 * Holds decoupled logic for all the API calls.
 */

const val BASE_URL = "https://taskie-rw.herokuapp.com"

class RemoteApi {

    fun loginUser(userDataRequest: UserDataRequest, onUserLoggedIn: (String?, Throwable?) -> Unit) {
        Thread(Runnable {
            val connection = URL("$BASE_URL/api/login").openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("Accept", "application/json")
            connection.readTimeout = 10000
            connection.connectTimeout = 10000
            connection.doOutput = true
            connection.doInput = true

            val requestJson = JSONObject()
            requestJson.put("email", userDataRequest.email)
            requestJson.put("password", userDataRequest.password)
            val body = requestJson.toString()

            val bytes = body.toByteArray()

            try {
                connection.outputStream.use { outputStream ->
                    outputStream.write(bytes)

                }
                val reader = InputStreamReader(connection.inputStream)

                reader.use { input ->
                    val response = StringBuilder()
                    val bufferedReader = BufferedReader(input)

                    bufferedReader.useLines { lines ->
                        lines.forEach {
                            response.append(it.trim())
                        }
                    }
                    val jsonObject = JSONObject(response.toString())
                    val token = jsonObject.getString("token")

                    onUserLoggedIn(token, null)


                }
            } catch (error: Throwable) {
                onUserLoggedIn(null, error)

            }


            connection.disconnect()
        }).start()

        fun registerUser(userDataRequest: UserDataRequest, onUserCreated: (String?, Throwable?) -> Unit) {
            Thread(Runnable {
                val connection = URL("$BASE_URL/api/register").openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json")
                connection.setRequestProperty("Accept", "application/json")
                connection.readTimeout = 10000
                connection.connectTimeout = 10000
                connection.doOutput = true
                connection.doInput = true

                val requestJson = JSONObject()
                requestJson.put("name", userDataRequest.name)
                requestJson.put("email", userDataRequest.email)
                requestJson.put("password", userDataRequest.password)
                val body = requestJson.toString()

                val bytes = body.toByteArray()

                try {
                    connection.outputStream.use { outputStream ->
                        outputStream.write(bytes)

                    }
                    val reader = InputStreamReader(connection.inputStream)

                    reader.use { input ->
                        val response = StringBuilder()
                        val bufferedReader = BufferedReader(input)

                        bufferedReader.useLines { lines ->
                            lines.forEach {
                                response.append(it.trim())
                            }
                        }

                      val jsonObject = JSONObject(response.toString())

                        onUserCreated(jsonObject.getString("message"), null)
                    }
                } catch (error: Throwable) {
                    onUserCreated(null, error)
                }

                connection.disconnect()

            }).start()
        }

        fun getTasks(onTasksReceived: (List<Task>, Throwable?) -> Unit) {
            onTasksReceived(listOf(
                    Task("id",
                            "Wash laundry",
                            "Wash the whites and colored separately!",
                            false,
                            1
                    ),
                    Task("id2",
                            "Do some work",
                            "Finish the project",
                            false,
                            3
                    )
            ), null)
        }

        fun deleteTask(onTaskDeleted: (Throwable?) -> Unit) {
            onTaskDeleted(null)
        }

        fun completeTask(onTaskCompleted: (Throwable?) -> Unit) {
            onTaskCompleted(null)
        }

        fun addTask(addTaskRequest: AddTaskRequest, onTaskCreated: (Task?, Throwable?) -> Unit) {
            onTaskCreated(
                    Task("id3",
                            addTaskRequest.title,
                            addTaskRequest.content,
                            false,
                            addTaskRequest.taskPriority
                    ), null
            )
        }

        fun getUserProfile(onUserProfileReceived: (UserProfile?, Throwable?) -> Unit) {
            onUserProfileReceived(UserProfile("mail@mail.com", "Filip", 10), null)
        }
    }
}