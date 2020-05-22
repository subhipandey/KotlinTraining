

package com.subhipandey.markme.main.presenter

import com.subhipandey.markme.main.MainContract
import com.subhipandey.markme.utils.ClassSection

class MainPresenter(private var view: MainContract.View?) : MainContract.Presenter {

    override fun onAttendanceOptionClick() {
        view?.navigateTo(ClassSection.ATTENDANCE)
    }

    override fun onGradingOptionClick() {
        view?.navigateTo(ClassSection.GRADING)
    }

    override fun onViewDestroyed() {
        view = null
    }
}
