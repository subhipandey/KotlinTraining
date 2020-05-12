

package com.subhipandey.android.guesscount

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_count.*

const val EXTRA_COUNT = "EXTRA_COUNT"

class CountActivity : AppCompatActivity() {

  private val userCount: Int by lazy {
    intent.getIntExtra(EXTRA_COUNT, 0)
  }
  private var startTimestamp = 0L
  private var stopTimestamp = 0L
  private val timeoutHandler = Handler()
  private val timeoutRunnable = object : Runnable {
    override fun run() {
      this@CountActivity.stopCounting()
      this@CountActivity.showTimeoutResults()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_count)
    setFinishOnTouchOutside(false)

    buttonGuess.setOnClickListener {
      stopCounting()
      showDifferenceResults()
    }

    prepareToStartCounting()
    startCounting()
  }

  private fun startCounting() {
    startTimestamp = System.currentTimeMillis()
    val timeoutMillis = userCount * 1000 + 10000L
    timeoutHandler.postDelayed(timeoutRunnable, timeoutMillis)
  }

  private fun stopCounting() {
    stopTimestamp = System.currentTimeMillis()
    timeoutHandler.removeCallbacksAndMessages(null)
  }

  private fun showDifferenceResults() {
    prepareToShowResults()

    val difference = (stopTimestamp - startTimestamp) / 1000
    val diffWithCount = Math.abs(userCount - difference.toInt())
    when {
      diffWithCount > 5 -> textViewGuessTitle.text = getString(R.string.count_result_bad)
      diffWithCount == 0 -> textViewGuessTitle.text = getString(R.string.count_result_excellent)
      else -> textViewGuessTitle.text = getString(R.string.count_result_good)
    }
    textViewGuessSubtitle.text = getString(R.string.count_result_difference, diffWithCount)
  }

  private fun showTimeoutResults() {
    prepareToShowResults()

    textViewGuessTitle.text = getString(R.string.count_result_timeout)
    textViewGuessSubtitle.text = getString(R.string.count_result_timeout_difference, userCount)
  }

  private fun prepareToShowResults() {
    textViewGuessTitle.visibility = View.VISIBLE
    textViewGuessSubtitle.visibility = View.VISIBLE
    buttonGuess.visibility = View.GONE
    progressBar.visibility = View.GONE
  }

  private fun prepareToStartCounting() {
    textViewGuessTitle.visibility = View.GONE
    textViewGuessSubtitle.visibility = View.GONE
    buttonGuess.visibility = View.VISIBLE
    progressBar.visibility = View.VISIBLE
  }

  override fun onDestroy() {
    stopCounting()
    super.onDestroy()
  }

}
