package com.subhipandey.android.photosapp.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import com.subhipandey.android.photosapp.app.SongUtils
import com.subhipandey.android.photosapp.app.photosappApplication

class SongService : Service() {

  private lateinit var player: MediaPlayer

  override fun onBind(intent: Intent): IBinder? {
    return null // Prevents binding with Activity
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    player = MediaPlayer.create(this, Uri.fromFile(SongUtils.songFile()))
    player.isLooping = true
    player.start()
    photosappApplication.isPlayingSong = true
    return START_STICKY
  }

  override fun onDestroy() {
    player.stop()
    photosappApplication.isPlayingSong = false
    super.onDestroy()
  }
}
