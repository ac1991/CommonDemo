package com.commondemo.xiaoyu.uilibrary.multilevellinkagemenu

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout

/**
 * Created by sqwu on 2018/4/7.
 */
class MultilevelLinkageMenu : LinearLayout, OnLinkageItemClickListener {
    var itemList: MutableList<List<String>> = mutableListOf()
    var linkageCount = 0
    var mOnLinkageItemClickListener: OnLinkageItemClickListener? = null
    var isConfig: Boolean = false

    constructor(context: Context?):this(context, null)

    constructor(context: Context?, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context, attrs, defStyleAttr){
        orientation = HORIZONTAL
        Log.d("MultilevelLinkageMenu","constructor")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("MultilevelLinkageMenu","onMeasure")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (!isConfig) {
            configChildViewParams()
            isConfig = true
        }
        Log.d("MultilevelLinkageMenu","onLayout")
    }

    fun addList(list: MutableList<String>){
        Log.d("MultilevelLinkageMenu","addList")
        if (list != null && list.size > 0){
            isConfig = false
            linkageCount++
            itemList.add(list)
            val linkageItemView = LinkageItemView(context)
            linkageItemView.addList(list, linkageCount - 1)
            linkageItemView.mOnLinkageItemClickListener = this
            addView(linkageItemView)
        }
    }

    private fun configChildViewParams(){
        val parentW = measuredWidth
        var childW = parentW/ childCount

        for (i in 0..(childCount - 1)){
            val childView: View = getChildAt(i)
            var layoutParams = childView.layoutParams
            if (layoutParams == null){
                layoutParams = LayoutParams(childW, MATCH_PARENT)
            }else{
                layoutParams.width = childW
                layoutParams.height = MATCH_PARENT
            }

            childView.layoutParams = layoutParams

//            isConfig = true

            Log.d("MultilevelLinkageMenu","configChildViewParams")
//            childView.invalidate()
        }

    }

    fun open(){
        animate().withEndAction({}).translationY(0f).setDuration(3000).start()
    }

    fun  close(){
        animate().withEndAction({}).translationY(-300f).setDuration(3000).start()
    }

    fun removeList(list: MutableList<String>){
        var position = itemList.indexOf(list)
        removeList(position)
    }

    fun removeList(position: Int){
        isConfig = false
        for (index in position..(linkageCount - 1)){
            removeViewAt(position)
            linkageCount--
        }
    }

    /**
     * 设置监听器，返回联动列位置
     */
    fun setOnLinkageItemClickListener(listener: OnLinkageItemClickListener){
        mOnLinkageItemClickListener = listener
    }

    override fun onLinkageItemClickListener(linkagePosition: Int, listPosition: Int, data: String) {
//        if (listPosition == linkageCount - 1){
//            close()
//        }
//
//        if (linkagePosition < linkageCount - 1 && listPosition == 0){
//            removeList(linkagePosition + 1)
//        }

        if (mOnLinkageItemClickListener != null){
            mOnLinkageItemClickListener!!.onLinkageItemClickListener(linkagePosition, listPosition, data)
        }
    }



}