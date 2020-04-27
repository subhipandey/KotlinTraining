

package com.subhipandey.android.spacingout.lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.subhipandey.android.spacingout.R
import com.subhipandey.android.spacingout.createViewModel
import kotlinx.android.synthetic.main.fragment_lookup.*
import kotlinx.android.synthetic.main.fragment_lookup.view.*

class LookupFragment : Fragment() {
  private val viewModel by lazy {
    createViewModel { LookupViewModel() }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_lookup, container, false)
    view.latitude.setOnEditorActionListener { _, actionId, _ ->
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        donePressed()
      }
      false
    }

    view.longitude.setOnEditorActionListener { _, actionId, _ ->
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        donePressed()
      }
      false
    }

    viewModel.imageLiveData.observe(this, Observer {
      Glide.with(this).load(it).into(view.image)
    })
    viewModel.showErrorLiveData.observe(this, Observer {
      Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show()
    })

    return view
  }

  private fun donePressed() {
    val latitude = latitude.text.toString().toFloatOrNull()
    val longitude = longitude.text.toString().toFloatOrNull()
    if (latitude != null && longitude != null) {
      viewModel.latLongInput(latitude, longitude)
    }
  }
}