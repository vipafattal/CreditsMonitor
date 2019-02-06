package com.magenta.creditsmonitor.recycler.holders

import android.view.ViewGroup
import com.magenta.creditsmonitor.R
import com.magenta.creditsmonitor.framework.TRANSITION_CARD
import com.magenta.creditsmonitor.model.BaseModel
import com.magenta.creditsmonitor.model.Credit
import com.magenta.creditsmonitor.recycler.listener.OnRecyclerViewClick
import com.magenta.creditsmonitor.framework.utils.extension.apiCall
import com.magenta.creditsmonitor.framework.utils.extension.inflater
import kotlinx.android.synthetic.main.item_credit.view.*

/**
 * Created by ${User} on ${Date}
 */

class CreditsViewHolder(parent: ViewGroup) : BaseViewHolder(parent.inflater(R.layout.item_credit)) {
    override fun onBind(data: BaseModel, position: Int, clickListener: OnRecyclerViewClick?) {
        data as Credit
        itemView.apply {
            apiCall(21) {
                transitionName = TRANSITION_CARD + position
            }
            credit_title.text = data.name
            amount_value_text.text = data.amount
            date_value_text.text = data.date
            status_value_text.text = data.status.code
            status_img.setImageResource(data.status.iconId)
            credit_icon.setImageResource(data.imageId)

            setOnClickListener {
                clickListener?.onItemClick(this, position)
            }

        }
    }
}