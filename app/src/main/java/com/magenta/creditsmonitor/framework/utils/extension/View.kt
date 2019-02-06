package com.magenta.creditsmonitor.framework.utils.extension

import android.animation.Animator
import android.animation.AnimatorInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimatorRes
import androidx.annotation.DimenRes
import androidx.annotation.LayoutRes
import androidx.cardview.widget.CardView

/**
 * Created by ${User} on ${Date}
 */

fun View.loadAnimator(@AnimatorRes animRes: Int, action:Animator.()-> Unit){
    val animator= AnimatorInflater.loadAnimator(context,animRes)
    animator.setTarget(this)
    action(animator)
    animator.start()
}

fun ViewGroup.inflater(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

inline fun View.createCard(cardView: CardView.() -> Unit): CardView {

    val card = CardView(context)
    cardView(card)

    return card
}

fun View.createCard(@DimenRes radius: Int, @DimenRes elevation: Int): CardView {
    val card = CardView(context)

    card.radius = resources.getDimension(radius)
    //card.cardElevation = resources.getDimension(elevation)

    return card
}

inline fun <reified view : ViewGroup> view.add(newView: View): view {
    addView(newView)
    return this
}
