

package com.subhipandey.android.photosapp.app

import android.content.Context
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

object PhotosUtils {

  private const val DATA_DIR = "data"
  private const val PHOTOS_FILENAME = "photos.json"
  private const val PHOTOS_KEY = "photos"
  private const val BANNER_KEY = "banner"

  @Throws(IOException::class)
  private fun getUrlAsString(urlAddress: String): String {
    val url = URL(urlAddress)

    val conn = url.openConnection() as HttpsURLConnection

    conn.requestMethod = "GET"
    conn.setRequestProperty("Accept", "application/json")

    return try {
      val inputStream = conn.inputStream

      if (conn.responseCode != HttpURLConnection.HTTP_OK) {
        throw IOException("${conn.responseMessage} for $urlAddress")
      }

      if (inputStream != null) {
        convertStreamToString(inputStream)
      } else {
        "Error retrieving $urlAddress"
      }
    } finally {
      conn.disconnect()
    }
  }

  fun photoUrlsFromJsonString(jsonString: String): ArrayList<String>? {
    val photoUrls = arrayListOf<String>()

    try {
      val photoArray = JSONObject(jsonString).getJSONArray(PHOTOS_KEY)
      for (i in 0 until photoArray.length()) {
        val photo = photoArray[i] as String
        photoUrls.add(photo)
      }
    } catch (e: JSONException) {
      Log.e("PhotosUtils", "Error parsing JSON")
      return null
    }

    return photoUrls
  }

  fun bannerFromJsonString(jsonString: String): String? {
    try {
      return JSONObject(jsonString).get(BANNER_KEY) as String
    } catch (e: JSONException) {
      Log.e("PhotosUtils", "Error parsing JSON")
    }

    return null
  }

  @Throws(IOException::class)
  private fun convertStreamToString(inputStream: InputStream): String {
    val reader = BufferedReader(InputStreamReader(inputStream))
    val sb = StringBuilder()
    var line: String? = reader.readLine()
    while (line != null) {
      sb.append(line).append("\n")
      line = reader.readLine()
    }
    reader.close()
    return sb.toString()
  }

  fun photoJsonString(): String? {
    return if (!dataFile().exists()) {
      fetchJsonString()
    } else {
      convertStreamToString(photoInputStream())
    }
  }

  private fun fetchJsonString(): String? {
    val string: String?
    string = getUrlAsString(Constants.PHOTOS_URL)
    try {
      val outputStream = photoOutputStream()
      outputStream.write(string.toByteArray())
      outputStream.close()
    } catch (e: IOException) {
      Log.e("FileRepository", "Error saving data")
    }
    return string
  }

  private fun dataFile(): File {
    val directory = photosappApplication.getAppContext().getDir(DATA_DIR, Context.MODE_PRIVATE)
    return File(directory, PHOTOS_FILENAME)
  }

  private fun photoOutputStream(): FileOutputStream {
    return FileOutputStream(dataFile())
  }

  private fun photoInputStream(): FileInputStream {
    return FileInputStream(dataFile())
  }
}
