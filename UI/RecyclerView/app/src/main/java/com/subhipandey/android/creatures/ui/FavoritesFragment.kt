package com.subhipandey.android.creatures.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subhipandey.android.creatures.R
import com.subhipandey.android.creatures.model.CreatureStore
import kotlinx.android.synthetic.main.fragment_favorites.*


class FavoritesFragment : Fragment() {
    private val adapter = CreatureAdapter(mutableListOf())

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
    }

    override fun onResume() {
        super.onResume()
      val favorites = CreatureStore.getFavoriteCreatures(context!!)
        favorites?.let {
            adapter.updateCreatures(favorites)
        }
    }

}