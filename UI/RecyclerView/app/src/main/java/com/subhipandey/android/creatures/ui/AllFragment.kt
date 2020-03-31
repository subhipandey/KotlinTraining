

package com.subhipandey.android.creatures.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.*
import com.subhipandey.android.creatures.R
import com.subhipandey.android.creatures.model.CreatureStore
import kotlinx.android.synthetic.main.fragment_all.*


class AllFragment : Fragment() {

  private val adapter = CreatureCardAdapter(CreatureStore.getCreatures().toMutableList())


    private lateinit var layoutManager: GridLayoutManager
    private lateinit var listItemDecoration: RecyclerView.ItemDecoration
    private lateinit var gridItemDecoration: RecyclerView.ItemDecoration
    private lateinit var listMenuItem: MenuItem
    private lateinit var gridMenuItem: MenuItem
    private var gridState = GridState.GRID


    companion object {
        fun newInstance(): AllFragment {
            return AllFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_all, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        listMenuItem = menu.findItem(R.id.action_span_1)
        gridMenuItem = menu.findItem(R.id.action_span_2)
        when (gridState) {
            GridState.LIST -> {
                listMenuItem.isEnabled = false
                gridMenuItem.isEnabled = true
            }
            GridState.GRID -> {
                listMenuItem.isEnabled = true
                gridMenuItem.isEnabled = false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_span_1 -> {
                gridState = GridState.LIST
                updateRecyclerView(1, listItemDecoration, gridItemDecoration)
                return true
            }
            R.id.action_span_2 -> {
                gridState = GridState.GRID
                updateRecyclerView(2, gridItemDecoration, listItemDecoration)
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

        layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return (adapter.spanSizeAtPosition(position))
            }
        }
        creatureRecyclerView.layoutManager = layoutManager
        creatureRecyclerView.adapter = adapter

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.creature_card_grid_layout_margin)

        listItemDecoration = SpacingItemDecoration(1, spacingInPixels)
        gridItemDecoration = SpacingItemDecoration(2, spacingInPixels)

        creatureRecyclerView.addItemDecoration(gridItemDecoration)

        creatureRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                adapter.scrollDirection = if (dy > 0) {
                    CreatureCardAdapter.ScrollDirection.DOWN
                } else {
                    CreatureCardAdapter.ScrollDirection.UP
                }
            }
        })
    }

    private fun updateRecyclerView(spanCount: Int, addItemDecoration: RecyclerView.ItemDecoration, removeItemDecoration: RecyclerView.ItemDecoration) {
        layoutManager.spanCount = spanCount
        adapter.jupiterSpanSize = spanCount
        creatureRecyclerView.removeItemDecoration(removeItemDecoration)
        creatureRecyclerView.addItemDecoration(addItemDecoration)
    }

    private enum class GridState {
        LIST, GRID
    }
}