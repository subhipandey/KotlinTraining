package com.subhipandey.android.creatures.ui

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.subhipandey.android.creatures.R
import com.subhipandey.android.creatures.app.inflate
import com.subhipandey.android.creatures.model.CompositeItem
import com.subhipandey.android.creatures.model.Creature
import com.subhipandey.android.creatures.model.Favorites
import kotlinx.android.synthetic.main.list_item_creature.view.*
import kotlinx.android.synthetic.main.list_item_planet_header.view.*
import java.lang.IllegalArgumentException
import java.util.*
import java.util.Collections.swap

class CreatureAdapter(private val creatures: MutableList<Creature>, private val itemDragListener: ItemDragListener)
    : RecyclerView.Adapter<CreatureAdapter.ViewHolder>(), ItemTouchHelperListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_creature))
    }

    override fun onBindViewHolder(holder: CreatureAdapter.ViewHolder, position: Int) {
        holder.bind(creatures[position])
    }

    override fun getItemCount() = creatures.size

    fun updateCreatures(creatures: List<Creature>) {
        this.creatures.clear()
        this.creatures.addAll(creatures)
        notifyDataSetChanged()
    }

    override fun onItemMove(recyclerView: RecyclerView, fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(creatures, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(creatures, i, i - 1)
            }
        }
        Favorites.saveFavorites(creatures.map { it.id }, recyclerView.context)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int) {
        Favorites.removeFavorite(creatures[position], viewHolder.itemView.context)
        creatures.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, ItemSelectedListener {

        private lateinit var creature: Creature

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(creature: Creature) {
            this.creature = creature
            val context = itemView.context
            itemView.creatureImage.setImageResource(context.resources.getIdentifier(creature.thumbnail, null, context.packageName))
            itemView.fullName.text = creature.fullName
            itemView.nickname.text = creature.nickname
            animateView(itemView)
            itemView.handle.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    itemDragListener.onItemDrag(this)
                }
                false
            }
        }

        override fun onClick(view: View) {
            val context = view.context
            val intent = CreatureActivity.newIntent(context, creature.id)
            context.startActivity(intent)
        }

        private fun animateView(viewToAnimate: View) {
            if (viewToAnimate.animation == null) {
                val animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.scale_xy)
                viewToAnimate.animation = animation
            }
        }

        override fun onItemSelected() {
            itemView.listItemContainer.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.selectedItem))
        }

        override fun onItemCleared() {
            itemView.listItemContainer.setBackgroundColor(0)
        }
    }
}