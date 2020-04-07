

package com.subhipandey.android.photosapp.ui.song

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subhipandey.android.photosapp.R
import com.subhipandey.android.photosapp.app.SongUtils
import kotlinx.android.synthetic.main.fragment_song.*

class SongFragment : Fragment() {

  companion object {
    fun newInstance(): SongFragment {
      return SongFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.fragment_song, container, false)
  }

  override fun onResume() {
    super.onResume()

    if (!SongUtils.songFile().exists()) {
      playButton.isEnabled = false
      stopButton.isEnabled = false
    }
  }
}