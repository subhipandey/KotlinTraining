package com.subhipandey.android.creatures.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subhipandey.android.creatures.R
import com.subhipandey.android.creatures.model.CreatureStore
import kotlinx.android.synthetic.main.activity_creature.*
import kotlinx.android.synthetic.main.fragment_favorites.*


class FavoritesFragment : Fragment(), ItemDragListener {

    private val adapter = CreatureAdapter(mutableListOf(), this)
    private lateinit var itemTouchHelper: ItemTouchHelper

    companion object {
        fun newInstance(): FavoritesFragment {
            return FavoritesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesRecyclerView.layoutManager = LinearLayoutManager(activity)
        favoritesRecyclerView.adapter = adapter
        setupItemTouchHelper()

        val heightInPixels = resources.getDimensionPixelSize(R.dimen.list_item_divider_height)
        favoritesRecyclerView.addItemDecoration(DividerItemDecoration(ContextCompat.getColor(context!!, R.color.black), heightInPixels))
    }

    override fun onResume() {
        super.onResume()
        val favorites = CreatureStore.getFavoriteCreatures(context!!)
        favorites?.let {
            adapter.updateCreatures(favorites)
        }
    }

    private fun setupItemTouchHelper() {
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(favoritesRecyclerView)
    }

    override fun onItemDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
}