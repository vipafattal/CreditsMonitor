package com.magenta.creditsmonitor.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AnticipateInterpolator
import android.view.animation.Interpolator
import android.view.animation.OvershootInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.fragment.app.Fragment
import com.magenta.creditsmonitor.R
import com.magenta.creditsmonitor.framework.AppViewModel
import com.magenta.creditsmonitor.framework.TRANSITION_CARD
import com.magenta.creditsmonitor.framework.TRANSITION_TOOLBAR
import com.magenta.creditsmonitor.framework.utils.dp
import com.magenta.creditsmonitor.framework.utils.extension.apiCall
import com.magenta.creditsmonitor.framework.utils.extension.loadAnimator
import com.magenta.creditsmonitor.framework.utils.extension.viewModelOf
import com.magenta.creditsmonitor.model.DataProvider.getDetailsData
import com.magenta.creditsmonitor.recycler.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.item_credit.*
import kotlinx.android.synthetic.main.item_credit.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class DetailsFragment : BaseFragment(), OnBackPressedListener {


    lateinit var appViewModel: AppViewModel

    override fun inflateViewId(): Int = R.layout.fragment_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        appViewModel = viewModelOf(AppViewModel::class.java)
        apiCall(21) {
            toolbar_detail.transitionName = TRANSITION_TOOLBAR
            card_details_credit.transitionName = TRANSITION_CARD + appViewModel.getCurrentCreditPosition().value
        }

        bindDataCreditData()

        animateFabs(false)

        details_negative_fab.setOnClickListener { onFragmentBackPressed() }

        details_recyclerView.adapter = RecyclerViewAdapter(getDetailsData(), null)
        details_recyclerView.setHasFixedSize(true)
    }

    override fun onFragmentBackPressed() {
        animateRecyclerView()
    }

    private fun animateRecyclerView() {
        details_recyclerView.loadAnimator(R.animator.credit_list_animator) {
            doOnStart {
                animateFabs(true)
            }
            doOnEnd {
            }
        }

    }

    private fun animateFabs(isOut: Boolean) {
        var translateTo = 0f
        val animatorSet = AnimatorSet()
        val interpolator: Interpolator

        if (isOut) {
            interpolator = AnticipateInterpolator(2f)
            translateTo = dp(140f) + 0f
            animatorSet.doOnEnd {
                activity?.supportFragmentManager?.popBackStack()
            }

        } else
            interpolator = OvershootInterpolator(4f)

        val negativeAnimFab = ObjectAnimator.ofFloat(details_negative_fab, "translationY", translateTo)
        val positiveAnimFab = ObjectAnimator.ofFloat(details_positive_fab, "translationY", translateTo)

        positiveAnimFab.startDelay = 100
        animatorSet.playTogether(negativeAnimFab, positiveAnimFab)
        animatorSet.duration = 650
        if (isOut) {

        } else
            animatorSet.interpolator = interpolator

        animatorSet.start()
    }

    private fun bindDataCreditData() {
        appViewModel.getCurrentCredit().value!!.apply {
            status_value_text.text = status.code
            date_value_text.text = date
            amount_value_text.text = amount
            credit_title.text = name
            credit_icon.setImageResource(imageId)
            status_img.setImageResource(status.iconId)
        }
    }
}
