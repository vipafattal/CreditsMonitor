package com.magenta.creditsmonitor.framework.utils.extension

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by ${User} on ${Date}
 */

inline fun RecyclerView.onScroll(crossinline action: (dx: Int, dy: Int) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            action(dx,dy)
        }
    })
}