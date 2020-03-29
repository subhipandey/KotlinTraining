

package com.subhipandey.android.creatures.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.*
import com.subhipandey.android.creatures.R
import com.subhipandey.android.creatures.model.CreatureStore
import kotlinx.android.synthetic.main.fragment_all.*


class AllFragment : Fragment() {

  private val adapter = CreatureCardAdapter(CreatureStore.getCreatures().toMutableList())


    private lateinit var layoutManager: StaggeredGridLayoutManager


  companion object {
    fun newInstance(): AllFragment {
      return AllFragment()
    }
  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_all, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id) {
            R.id.action_span_1 -> {
                showListView()
                return true
            }
            R.id.action_span_2 -> {
                showGridView()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.fragment_all, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

     layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)

    creatureRecyclerView.layoutManager = layoutManager
    creatureRecyclerView.adapter = adapter


  }

    private fun showListView() {
        layoutManager.spanCount = 1

    }

    private fun showGridView() {
        layoutManager.spanCount = 2

    }
}