

package com.subhipandey.markme.feature.view.adapter

interface SpAdapter<T> {
    fun getData() : List<T>?
    fun updateData(data: List<T>)
}