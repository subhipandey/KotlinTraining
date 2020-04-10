

package com.subhipandey.android.photosapp.ui.song

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subhipandey.android.photosapp.R
import com.subhipandey.android.photosapp.app.Constants
import com.subhipandey.android.photosapp.app.photosappApplication
import com.subhipandey.android.photosapp.app.SongUtils
import com.subhipandey.android.photosapp.service.DownloadIntentService
import com.subhipandey.android.photosapp.service.SongService
import kotlinx.android.synthetic.main.fragment_song.*

class SongFragment : Fragment() {

  companion object {
    fun newInstance(): SongFragment {
      return SongFragment()
    }
  }

  private val receiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      val param = intent?.getStringExtra(DownloadIntentService.DOWNLOAD_COMPLETE_KEY)
      Log.i("SongFragment", "Received broadcast for $param")
      if (SongUtils.songFile().exists()) {
        enablePlayButton()
      }
    }
  }

  override fun onStart() {
    super.onStart()
    LocalBroadcastManager.getInstance(photosappApplication.getAppContext())
        .registerReceiver(receiver, IntentFilter(DownloadIntentService.DOWNLOAD_COMPLETE))
  }

  override fun onStop() {
    super.onStop()
    LocalBroadcastManager.getInstance(photosappApplication.getAppContext())
        .unregisterReceiver(receiver)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.fragment_song, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    downloadButton.setOnClickListener {
      DownloadIntentService.startActionDownload(view.context, Constants.SONG_URL)
      disableMediaButtons()
      stopPlaying()
    }

    playButton.setOnClickListener {
      val ctx = context
      if (ctx != null) {
        ContextCompat.startForegroundService(ctx, Intent(ctx, SongService::class.java))
      }
      enableStopButton()
    }

    stopButton.setOnClickListener {
      stopPlaying()
    }
  }

  private fun stopPlaying() {
    activity?.stopService(Intent(context, SongService::class.java))
    enablePlayButton()
  }

  override fun onResume() {
    super.onResume()

    if (photosappApplication.isPlayingSong) {
      enableStopButton()
    } else {
      enablePlayButton()
    }

    if (!SongUtils.songFile().exists()) {
      disableMediaButtons()
    }
  }

  private fun enablePlayButton() {
    playButton.isEnabled = true
    stopButton.isEnabled = false
  }

  private fun enableStopButton() {
    playButton.isEnabled = false
    stopButton.isEnabled = true
  }

  private fun disableMediaButtons() {
    playButton.isEnabled = false
    stopButton.isEnabled = false
  }
}