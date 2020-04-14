

package com.subhipandey.android.w00tze.ui.gists


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.model.*
import com.subhipandey.android.w00tze.viewmodel.GistsViewModel
import kotlinx.android.synthetic.main.fragment_gists.*


class GistsFragment : Fragment(), GistAdapter.GistAdapterListener {

  private lateinit var gistsViewModel: GistsViewModel

  private val adapter = GistAdapter(mutableListOf(), this)

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_gists, container, false)

    gistsViewModel = ViewModelProviders.of(this).get(GistsViewModel::class.java)

    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)



    gistsViewModel.getGists().observe(this, Observer<Either<List<Gist>>> { either ->
      if (either?.status == Status.SUCCESS && either.data != null) {
        adapter.updateGists(either.data)
      } else {
        if (either?.error == ApiError.GISTS) {
          Toast.makeText(context, getString(R.string.error_retrieving_gists), Toast.LENGTH_SHORT).show()
        }
      }
    })

    fab.setOnClickListener {
      showGistDialog()
    }
  }

    override fun deleteGist(gist: Gist) {
        gistsViewModel.deleteGist(gist).observe(this, Observer<Either<EmptyResponse>> { either ->
            if (either?.status == Status.SUCCESS) {
                adapter.deleteGist(gist)
            } else {
                if (either?.error == ApiError.DELETE_GIST) {
                    Toast.makeText(context, getString(R.string.error_deleting_gist), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

  internal fun sendGist(description: String, filename: String, content: String) {
    gistsViewModel.sendGist(description, filename, content).observe(this, Observer<Either<Gist>> { either ->
      if (either?.status == Status.SUCCESS && either.data != null) {
        adapter.addGist(either.data)
      } else {
        if (either?.error == ApiError.POST_GIST) {
          Toast.makeText(context, getString(R.string.error_posting_gist), Toast.LENGTH_SHORT).show()
        }
      }
    })
  }
}