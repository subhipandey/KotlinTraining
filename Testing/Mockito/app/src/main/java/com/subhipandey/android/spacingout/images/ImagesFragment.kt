

package com.subhipandey.android.spacingout.images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.subhipandey.android.spacingout.R
import com.subhipandey.android.spacingout.SpacingAnalytics
import com.subhipandey.android.spacingout.createViewModel
import com.subhipandey.android.spacingout.network.SpacingOutApi
import kotlinx.android.synthetic.main.fragment_images.view.*

class ImagesFragment : Fragment() {

  private val viewModel by lazy {
    createViewModel { ImagesViewModel(ImageListProvider(SpacingOutApi.create()), SpacingAnalytics()) }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_images, container, false)
    val adapter = ImagesAdapter()
    view.list.layoutManager = LinearLayoutManager(container?.context)
    view.list.adapter = adapter
    viewModel.imageLiveData.observe(this, Observer {
      adapter.items = it
    })
    viewModel.errorLiveData.observe(this, Observer {
      Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show()
    })

    return view
  }
}