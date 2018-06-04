package com.commondemo.xiaoyu.commondemo.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.commondemo.xiaoyu.commondemo.R

/**
 * Created by Xiaoyu on 2018/4/7.
 */
class RecyclerViewHolder( itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var name : TextView;
    var icon: ImageView
    init {
        name = itemView?.findViewById<TextView>(R.id.name)!!
        icon = itemView?.findViewById(R.id.icon)
    }

}

