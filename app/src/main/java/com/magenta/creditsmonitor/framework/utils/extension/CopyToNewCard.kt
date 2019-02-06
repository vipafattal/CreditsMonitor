package com.magenta.creditsmonitor.framework.utils.extension

import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.core.view.drawToBitmap
import com.magenta.creditsmonitor.R
import com.magenta.creditsmonitor.framework.utils.dp

fun View.copyToNewCard(): View {

        val copy = ImageView(context)
        val bitmap = this.drawToBitmap()
        copy.setImageBitmap(bitmap)
        // On pre-Lollipop when we create a copy, the card view's shadow is copied too as content and
        // we do not need an additional card view.
        val newCard =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                createCard(R.dimen.card_radius, R.dimen.card_elevation).add(copy)
            else
                copy

        newCard.apply {
            layoutParams = this@copyToNewCard.layoutParams
            layoutParams.height = this@copyToNewCard.height
            layoutParams.width = this@copyToNewCard.width
            x = this@copyToNewCard.x
            y = this@copyToNewCard.y
            translationX = 0f
        }

        return newCard
    }