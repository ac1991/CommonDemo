package com.commondemo.xiaoyu.commondemo.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Xiaoyu on 2018/4/7.
 */
class SpaceItemDecoration: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent!!.getChildPosition(view) != 0){
            outRect!!.left = 20;
        }
    }
}