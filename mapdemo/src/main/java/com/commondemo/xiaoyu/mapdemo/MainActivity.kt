package com.commondemo.xiaoyu.mapdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.marker_view_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        marker.setOnClickListener(){
            startActivity(Intent(MainActivity@this, MarkerActivity::class.java))
        }
    }
}
