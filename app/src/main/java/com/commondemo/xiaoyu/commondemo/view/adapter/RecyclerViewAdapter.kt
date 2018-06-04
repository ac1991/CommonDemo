package com.commondemo.xiaoyu.commondemo.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.commondemo.xiaoyu.commondemo.R
import com.commondemo.xiaoyu.commondemo.view.viewholder.RecyclerViewHolder

/**
 * Created by Xiaoyu on 2018/4/7.
 */



class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>{

    val mContext : Context
    val mDataList: MutableList<String>

    constructor(context: Context, datas: MutableList<String>):super(){
        mContext = context;
        mDataList = datas;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var viewHolder: RecyclerViewHolder = holder as RecyclerViewHolder
        viewHolder.name.text =  mDataList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false)
        var viewHolder: RecyclerViewHolder = RecyclerViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
       return  mDataList.size
    }
}