package com.commondemo.xiaoyu.uilibrary.multilevellinkagemenu

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.commondemo.xiaoyu.uilibrary.R
import kotlinx.android.synthetic.main.linkage_view_layout.view.*


/**
 * Created by sqwu on 2018/5/2.
 */
class LinkageItemView :LinearLayout, OnRecyclerViewItemClickListener {
    lateinit var mList:MutableList<String>
    var mPostion: Int = 0
    var mOnLinkageItemClickListener: OnLinkageItemClickListener? = null

    constructor(context: Context?):this(context, null)

    constructor(context: Context?, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context, attrs, defStyleAttr){
//        orientation = HORIZONTAL
        View.inflate(context, R.layout.linkage_view_layout, this)
        Log.d("LinkageItemView","constructor")
    }

    /**
     * @param list 需要展示的数据集
     * @param position 当前联动列所在父控件的位置
     */
    fun addList(list: MutableList<String>, position: Int){
        mList = list
        mPostion = position
        linkage_view_list.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
        val adapter = LinkageItemAdapter(list)
        adapter.mListener = this
        linkage_view_list.adapter = adapter
        Log.d("LinkageItemView","addList")
    }

    /**
     * 设置监听器，返回联动列位置
     */
    fun setOnLinkageItemClickListener(listener: OnLinkageItemClickListener){
        mOnLinkageItemClickListener = listener
    }

    override fun onItemClickListener(position: Int, data: String) {
        if (mOnLinkageItemClickListener != null){
            mOnLinkageItemClickListener?.onLinkageItemClickListener(mPostion, position, data)
        }
    }
}