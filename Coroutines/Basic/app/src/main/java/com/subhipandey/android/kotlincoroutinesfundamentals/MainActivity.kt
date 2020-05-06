
package com.subhipandey.android.kotlincoroutinesfundamentals

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val mainLooper = mainLooper

    // Your code
    Thread(Runnable {
      val imageUrl = URL("https://wallpaperplay.com/walls/full/1/c/7/38027.jpg")
      val connection = imageUrl.openConnection() as HttpURLConnection
      connection.doInput = true
      connection.connect()

      val inputStream = connection.inputStream
      val bitmap = BitmapFactory.decodeStream(inputStream)

      Handler(Looper.getMainLooper()).post { image.setImageBitmap(bitmap) }
    }).start()
  }
}