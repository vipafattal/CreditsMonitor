package com.magenta.creditsmonitor.recycler;

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magenta.creditsmonitor.recycler.listener.OnRecyclerViewClick
import com.magenta.creditsmonitor.model.BaseModel
import com.magenta.creditsmonitor.model.Credit
import com.magenta.creditsmonitor.recycler.holders.BaseViewHolder
import com.magenta.creditsmonitor.recycler.holders.CreditsViewHolder
import com.magenta.creditsmonitor.recycler.holders.DetailsViewHolder

/**
 * Created by ${User} on ${Date}
 */
class RecyclerViewAdapter(private val dataList: List<BaseModel>,private val clickListener: OnRecyclerViewClick?) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return if (dataList[0] is Credit)
            CreditsViewHolder(parent)
        else
            DetailsViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
            holder.onBind(dataList[position],position,clickListener)
    }


}