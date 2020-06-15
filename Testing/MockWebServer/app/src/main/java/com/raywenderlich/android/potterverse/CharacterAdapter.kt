/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.potterverse

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_character_viewholder.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

  private val characterList = mutableListOf<CharacterModel>()

  fun setCharacterList(characterList: List<CharacterModel>) {
    this.characterList.clear()
    this.characterList.addAll(characterList)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_character_viewholder,
        parent, false)
    return CharacterViewHolder(view)
  }

  override fun getItemCount() = characterList.size

  @SuppressLint("DefaultLocale")
  override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
    val character = characterList[position]
    with(holder) {
      characterNameTextView.text = String.format(characterNameTextView.context.getString(R.string
          .name_placeholder), character.name)
      characterRoleTextView.text = String.format(characterRoleTextView.context.getString(R.string
          .role_placeholder), character.role?.capitalize() ?: "Unknown")
      orderOfThePhoenixTextView.text = String.format(orderOfThePhoenixTextView.context.getString(R.string
          .orderOfThePhoenix_placeholder), character.orderOfThePhoenix)
    }
  }

  inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val characterNameTextView: TextView = itemView.character_name_textview
    val characterRoleTextView: TextView = itemView.character_role_textview
    val orderOfThePhoenixTextView: TextView = itemView.orderOfThePhoenix_textview
  }
}