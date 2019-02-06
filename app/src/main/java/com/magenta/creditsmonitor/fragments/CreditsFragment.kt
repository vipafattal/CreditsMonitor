package com.magenta.creditsmonitor.fragments


import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.view.doOnLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.magenta.creditsmonitor.R
import com.magenta.creditsmonitor.framework.AppMain.Companion.appMainContext
import com.magenta.creditsmonitor.framework.AppViewModel
import com.magenta.creditsmonitor.framework.TRANSITION_TOOLBAR
import com.magenta.creditsmonitor.framework.utils.EdgeDecorator
import com.magenta.creditsmonitor.framework.utils.dp
import com.magenta.creditsmonitor.framework.utils.extension.*
import com.magenta.creditsmonitor.model.DataProvider.getCreditsData
import com.magenta.creditsmonitor.recycler.RecyclerViewAdapter
import com.magenta.creditsmonitor.recycler.listener.OnRecyclerViewClick
import kotlinx.android.synthetic.main.fragment_credits.*
import kotlinx.android.synthetic.main.toolbar_credit.*


class CreditsFragment : BaseFragment(), OnRecyclerViewClick {
    private val toolbarDetailsHeight by lazy(LazyThreadSafetyMode.NONE) {
        resources.getDimensionPixelOffset(R.dimen.toolbar_details_height).toFloat()
    }
    private lateinit var appViewModel: AppViewModel

    override fun inflateViewId(): Int = R.layout.fragment_credits

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appViewModel = viewModelOf(AppViewModel::class.java)
        setUpToolbar()
        setupRecyclerView()

        updateThemeIcon()
        changeThemeImg.setOnClickListener {
            appMainContext.changeThemeMode()
            activity!!.recreate()
        }
    }

    private fun setUpToolbar() {
        apiCall(21) {
            toolbar_details_transition.transitionName = TRANSITION_TOOLBAR
        }
        toolbar_details_transition.translationY = -dp(toolbarDetailsHeight).toFloat()
        val toolbarCreditHeight = dp(56f).toFloat()
        toolbar_credit.translationY = -toolbarCreditHeight

        credit_root_view.doOnLayout {
            toolbar_credit.animate()
                .translationY(0f)
                .alpha(1f)
                .setDuration(500)
                .start()
        }
    }

    private fun setupRecyclerView() {
        credits_recyclerView.adapter = RecyclerViewAdapter(creditList, this)
        val topEdgeDecorator = EdgeDecorator(dp(12f))
        credits_recyclerView.addItemDecoration(topEdgeDecorator)
        credits_recyclerView.setHasFixedSize(true)
        setupScrollRecycler()
    }

    private fun setupScrollRecycler() {
        val elevation = resources.getDimension(R.dimen.toolbar_elevation)
        val layoutManger = credits_recyclerView.layoutManager as LinearLayoutManager
        credits_recyclerView.onScroll { dx, dy ->
            if (layoutManger.findFirstCompletelyVisibleItemPosition() == 0) {
                if (toolbar_credit.cardElevation > 0f) {
                }
                toolbar_credit.animateElevation(true)
            } else
                toolbar_credit.cardElevation = elevation
        }
    }

    private val creditList = getCreditsData()
    override fun onItemClick(childView: View, position: Int) {
        val transaction = initFragmentTransaction(childView)
        appViewModel.setSelectedCredit(creditList[position], position)

        val newCreditCard = childView.copyToNewCard()
        val marginTop = if (!appMainContext.isNightModeEnabled) dp(15f) else 0
        newCreditCard.y += toolbar_credit.height + marginTop


        credit_root_view.addView(newCreditCard)
        childView.invisible()
        animateView(newCreditCard, transaction)
    }


    private fun animateView(view: View, transaction: FragmentTransaction?) {
        AnimatorInflater.loadAnimator(activity, R.animator.credit_list_animator).apply {

            setTarget(credits_recyclerView)

            doOnStart {
                if (toolbar_credit.cardElevation > 0)
                    toolbar_credit.animateElevation(true)
            }

            doOnEnd {
                val newCardAnim = ObjectAnimator.ofFloat(view, "y", toolbarDetailsHeight - view.height / 2)
                val creditToolbarAnim = ObjectAnimator.ofFloat(toolbar_credit, "y", -toolbar_credit.height + 0f)
                val detailsToolbarAnim = ObjectAnimator.ofFloat(toolbar_details_transition, "translationY", 0f)
                val animSet = AnimatorSet()
                animSet.interpolator = AccelerateDecelerateInterpolator()
                animSet.playTogether(newCardAnim, detailsToolbarAnim, creditToolbarAnim)
                animSet.duration = 500
                animSet.start()
                animSet.doOnEnd {
                    transaction?.commitAllowingStateLoss()
                }

            }
        }.start()
    }

    private fun initFragmentTransaction(view: View): FragmentTransaction? =
        fragmentManager!!.transaction(false) {
            val detailsFragment = DetailsFragment()
            apiCall(21) {


                detailsFragment.transitionAnimator(
                    R.transition.shared_details_credit_enter,
                    R.transition.shared_details_credit_exit
                )

                addSharedElement(toolbar_details_transition, toolbar_details_transition.transitionName)
                addSharedElement(view, view.transitionName)
            }
            replace(R.id.fragment_container, detailsFragment)
            addToBackStack(null)
        }

    private fun updateThemeIcon() {
        changeThemeImg.setImageResource(appMainContext.getThemeIcon())
    }

    companion object {
        const val TAG = "Credits-Fragment"
    }
}





