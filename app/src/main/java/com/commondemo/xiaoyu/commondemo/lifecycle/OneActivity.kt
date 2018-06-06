package com.commondemo.xiaoyu.commondemo.lifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.commondemo.xiaoyu.commondemo.R
import kotlinx.android.synthetic.main.activity_one.*

class OneActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        initView()
    }

    fun initView(){
        button_next.setOnClickListener(){
            startActivity(Intent(this, TwoActivity::class.java))
        }
    }
}
