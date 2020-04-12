

package com.subhipandey.android.w00tze.ui.gists

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.model.Gist
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

    gistsRecyclerView.layoutManager = LinearLayoutManager(context)
    gistsRecyclerView.adapter = adapter

    val itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
    itemTouchHelper.attachToRecyclerView(gistsRecyclerView)

    gistsViewModel.getGists().observe(this, Observer<List<Gist>> { gists ->
      adapter.updateGists(gists ?: emptyList())
    })

    fab.setOnClickListener {
      showGistDialog()
    }
  }

  override fun deleteGist(gist: Gist) {
    // TODO: call view model
  }

  internal fun sendGist(description: String, filename: String, content: String) {
    println("Sending gist: $description - $filename - $content")
  }
}