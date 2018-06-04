package com.commondemo.xiaoyu.commondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.commondemo.xiaoyu.commondemo.view.SpaceItemDecoration
import com.commondemo.xiaoyu.commondemo.view.adapter.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var datas: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initData()
        initView()

    }

    fun initData(){
        datas = mutableListOf()
        for (i in 0..10) {
            datas.add("name" + i)
        }
    }

    fun initView(){
        val liniearLayoutManager:LinearLayoutManager = LinearLayoutManager(this);
        liniearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_view.layoutManager = liniearLayoutManager
        recycler_view.adapter = RecyclerViewAdapter(this, datas)
        recycler_view.addItemDecoration(SpaceItemDecoration())

    }
}
