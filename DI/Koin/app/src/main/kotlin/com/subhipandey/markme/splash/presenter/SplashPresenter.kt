
package com.subhipandey.markme.splash.presenter

import com.subhipandey.markme.splash.SplashContract

class SplashPresenter(private var view: SplashContract.View?) : SplashContract.Presenter {

    override fun onViewCreated() {
        view?.finishView()
    }

    override fun onViewDestroyed() {
        view = null
    }
}
