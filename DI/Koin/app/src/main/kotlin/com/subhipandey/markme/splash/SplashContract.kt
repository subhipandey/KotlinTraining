

package com.subhipandey.markme.splash

interface SplashContract {
    interface View {
        fun finishView()
    }

    interface Presenter {
        // View updates
        fun onViewCreated()
        fun onViewDestroyed()
    }
}
