package com.commondemo.xiaoyu.uilibrary.multilevellinkagemenu

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.commondemo.xiaoyu.uilibrary.R

/**
 * Created by sqwu on 2018/5/2.
 */
class LinkageItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    lateinit var text: TextView
    init {
        text = itemView!!.findViewById(R.id.linkage_list_item_tv)
        Log.d("LinkageItemViewHolder","init")
    }
}