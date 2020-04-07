

package com.subhipandey.android.photosapp.app

import android.content.Context
import android.util.Log
import java.io.*
import java.net.URL

object SongUtils {
  fun download(urlString: String) {
    try {
      val songDir = songDirectory()
      if (!songDir.exists()) {
        songDir.mkdirs()
      }

      val f = songFile()
      val url = URL(urlString)

      val input: InputStream = BufferedInputStream(url.openStream())
      val output: OutputStream = FileOutputStream(f)

      val data = ByteArray(1024)

      var total = 0L
      var count = input.read(data)
      while (count != -1) {
        total++
        Log.i("SongUtils", "$total")

        output.write(data, 0, count)
        count = input.read(data)
      }

      output.flush()
      output.close()
      input.close()
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun songDirectory() = photosappApplication.getAppContext().getDir(Constants.SONGS_DIRECTORY, Context.MODE_PRIVATE)

  fun songFile() = File(songDirectory(), Constants.SONG_FILENAME)
}