package com.commondemo.xiaoyu.uilibrary.multilevellinkagemenu

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.commondemo.xiaoyu.uilibrary.R

/**
 * Created by sqwu on 2018/5/2.
 */
class LinkageItemAdapter(var list:MutableList<String>) : RecyclerView.Adapter<LinkageItemViewHolder>() {
    var mListener: OnRecyclerViewItemClickListener? = null
    override fun onBindViewHolder(holder: LinkageItemViewHolder?, position: Int) {

        Log.d("LinkageItemAdapter","onBindViewHolder")
        holder?.text?.text = list.get(position)
        holder?.text?.setOnClickListener(){
            if (mListener != null){
                mListener!!.onItemClickListener(position, list.get(position))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LinkageItemViewHolder {
        Log.d("LinkageItemAdapter","onCreateViewHolder")
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.linkage_item_recycle_item, parent, false)
        return LinkageItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (list != null && list.size > 0) {
            return list.size
        }
        return 0
    }

    fun setOnRecyclerViewItemClickListener(listener: OnRecyclerViewItemClickListener){
        mListener = listener
    }
}