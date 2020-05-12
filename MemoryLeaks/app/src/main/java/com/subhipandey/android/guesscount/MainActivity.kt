

package com.subhipandey.android.guesscount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val DEFAULT_COUNT = 10

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.AppTheme)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    editTextCount.setText(DEFAULT_COUNT.toString())
    buttonStart.setOnClickListener {
      startCounting()
    }
  }

  private fun startCounting() {
    val count = editTextCount.text.toString()
    if (count.isBlank()) {
      showCountIsRequiredError()
      return
    }
    hideCountIsRequiredError()

    val intent = Intent(this, CountActivity::class.java).apply {
      putExtra(EXTRA_COUNT, count.toInt())
    }
    startActivity(intent)
  }

  private fun showCountIsRequiredError() {
    layoutTextCount.error = getString(R.string.main_enter_value)
    layoutTextCount.isErrorEnabled = true
  }

  private fun hideCountIsRequiredError() {
    layoutTextCount.error = ""
    layoutTextCount.isErrorEnabled = false
  }
}
