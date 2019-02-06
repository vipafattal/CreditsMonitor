package com.magenta.creditsmonitor.recycler.holders

import android.view.ViewGroup
import com.magenta.creditsmonitor.R
import com.magenta.creditsmonitor.framework.utils.extension.inflater
import com.magenta.creditsmonitor.recycler.listener.OnRecyclerViewClick
import com.magenta.creditsmonitor.model.BaseModel
import com.magenta.creditsmonitor.model.Detail
import kotlinx.android.synthetic.main.item_details.view.*

/**
 * Created by ${User} on ${Date}
 */

class DetailsViewHolder(parent: ViewGroup) : BaseViewHolder(parent.inflater(R.layout.item_details)) {
    override fun onBind(data: BaseModel,position:Int, clickListener: OnRecyclerViewClick?) {
        data as Detail
        itemView.apply {
            tv_details_title.text = data.title
            tv_details_subtitle.text = data.subtitle
            tv_details_amount.text = data.amount
        }
    }
}