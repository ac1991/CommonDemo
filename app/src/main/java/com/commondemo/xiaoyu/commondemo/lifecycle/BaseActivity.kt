package com.commondemo.xiaoyu.commondemo.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.commondemo.xiaoyu.commondemo.R
import com.commondemo.xiaoyu.utils.Logger

/**
 * Created by Xiaoyu on 2018/6/5.
 */
open class BaseActivity: AppCompatActivity() {

    var TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d(TAG, "onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Logger.d(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Logger.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Logger.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Logger.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Logger.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d(TAG, "onDestroy")
    }
}