

package com.subhipandey.android.subhipandey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.subhipandey.android.subhipandey.details.DetailsFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

  private lateinit var playerViewModel: PlayerViewModel
  private lateinit var adapter: PlayerAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView.layoutManager =
        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    recyclerView.addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView
        .VERTICAL))
    adapter = PlayerAdapter(mutableListOf())
    recyclerView.adapter = adapter
    adapter.setOnPlayerTapListener { player ->
      val fragment = DetailsFragment.newInstance(player)

      fragment.show(supportFragmentManager, "DetailsFragment")
    }

    playerViewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)

    playerViewModel.getAllPlayers().observe(this, Observer<List<PlayerListItem>> { players ->
      adapter.swapData(players)
    })


    val players = playerViewModel.getAllPlayers()
    adapter.swapData(players)
  }
}
