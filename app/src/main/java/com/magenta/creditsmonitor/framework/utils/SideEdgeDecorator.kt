package com.magenta.creditsmonitor.framework.utils


import android.graphics.Rect

import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 *
 * Created by anthonykiniyalocts on 12/8/16.
 *
 *
 *
 * Quick way to add padding to first and last item in recyclerview via decorators
 *
 */

/**
 *
 * EdgeDecorator
 *
 * @param edgePadding padding set on the left side of the first item and the right side of the last item
 */
class SideEdgeDecorator(private val edgePadding: Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemCount = state.itemCount
        val itemPosition = parent.getChildAdapterPosition(view)

        when {
            // no position, leave it alone
            itemPosition == RecyclerView.NO_POSITION -> return
            // first item
            itemPosition == 0 -> outRect.set(edgePadding, view.paddingTop, view.paddingRight, view.paddingBottom)
            // last item
            itemCount > 0 && itemPosition == itemCount - 1 -> outRect.set(view.paddingLeft, view.paddingTop, edgePadding, view.paddingBottom)
            // every other item
            else -> outRect.set(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)
        }
    }

}