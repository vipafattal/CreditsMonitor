package com.magenta.creditsmonitor.recycler.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.magenta.creditsmonitor.recycler.listener.OnRecyclerViewClick
import com.magenta.creditsmonitor.model.BaseModel


abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view){
    abstract fun onBind(data:BaseModel,position:Int,clickListener: OnRecyclerViewClick?)
}