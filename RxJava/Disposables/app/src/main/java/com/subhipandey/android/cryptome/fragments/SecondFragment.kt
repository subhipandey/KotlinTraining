package com.subhipandey.android.cryptome.fragments

import android.os.Bundle

class SecondFragment: BaseFragment() {

  companion object {
    fun newInstance(currencies: String): SecondFragment {
      val bundle = Bundle()
      bundle.putString("currencies", currencies)

      val fragment = SecondFragment()
      fragment.arguments = bundle

      return fragment
    }
  }

}