

package com.subhipandey.android.cheesefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subhipandey.android.cheesefinder.database.Cheese
import com.subhipandey.android.cheesefinder.database.CheeseDatabase
import com.subhipandey.android.cheesefinder.ui.CheckableImageView
import io.reactivex.BackpressureStrategy
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_item.view.*

class CheeseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  var compositeDisposable = CompositeDisposable()

  var cheeses: List<Cheese> = listOf()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun getItemCount() = cheeses.size

  override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
    super.onDetachedFromRecyclerView(recyclerView)
    compositeDisposable.clear()
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val cheese = cheeses[position]
    holder.itemView.textView.text = cheese.name
    holder.itemView.imageFavorite.isChecked = cheese.favorite == 1

    compositeDisposable.add(
        Maybe.create<Boolean> { emitter ->

          emitter.setCancellable {
            holder.itemView.imageFavorite.setOnClickListener(null)
          }

          holder.itemView.imageFavorite.setOnClickListener {
            emitter.onSuccess((it as CheckableImageView).isChecked)
          }
        }.toFlowable().onBackpressureLatest()
            .observeOn(Schedulers.io())
            .map { isChecked ->
              cheese.favorite = if (!isChecked) 1 else 0
              val database = CheeseDatabase.getInstance(holder.itemView.context).cheeseDao()
              database.favoriteCheese(cheese)
              cheese.favorite
            }
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe {
              holder.itemView.imageFavorite.isChecked = it == 1
            }
    )
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}