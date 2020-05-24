

package com.subhipandey.android.currency

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_converter.*


class ConverterActivity : AppCompatActivity() {

  companion object {
    private val currencies = listOf(Dollar(), Euro(), Crypto())

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_converter)

    val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
            currencies.map { it.name })

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    currency.adapter = adapter

    convert.setOnClickListener {
      val low = currencyFromSelection()
      val high = currencyFromSelection()
    }

  }
  private fun currencyFromSelection() =
          when (currencies[currency.selectedItemPosition]) {
            is Dollar -> Dollar()
            is Euro -> Euro()
            is Crypto -> Crypto()
          }

}
