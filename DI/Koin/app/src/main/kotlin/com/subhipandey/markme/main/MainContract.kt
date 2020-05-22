

package com.subhipandey.markme.main

import com.subhipandey.markme.utils.ClassSection

interface MainContract {
    interface View {
        fun navigateTo(section: ClassSection)
    }

    interface Presenter {
        // User Actions
        fun onViewDestroyed()
        fun onAttendanceOptionClick()
        fun onGradingOptionClick()
    }
}
