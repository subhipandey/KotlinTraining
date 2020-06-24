

package com.subhipandey.android.taskie.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.subhipandey.android.taskie.ui.notes.NotesFragment
import com.subhipandey.android.taskie.ui.profile.ProfileFragment

/**
 * Displays the pages for the main screen.
 */
class MainPagerAdapter(fragmentManager: FragmentManager) :
  FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  private val fragments = listOf(NotesFragment(), ProfileFragment())
  private val titles = listOf("Notes", "Profile")

  override fun getCount(): Int = fragments.size
  override fun getItem(position: Int): Fragment = fragments[position]
  override fun getPageTitle(position: Int): CharSequence? = titles[position]
}