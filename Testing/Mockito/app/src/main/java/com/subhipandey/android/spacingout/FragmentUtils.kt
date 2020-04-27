

package com.subhipandey.android.spacingout

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified ViewModelClass : ViewModel> Fragment.createViewModel(
    noinline factory: () -> ViewModelClass
): ViewModelClass {
    val viewModelFactory = buildViewModelProviderFactory(factory)

    return ViewModelProviders.of(this, viewModelFactory).get(ViewModelClass::class.java)
}


fun buildViewModelProviderFactory(factory: () -> ViewModel): ViewModelProvider.Factory {
    return object: ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return factory() as T
        }
    }
}
