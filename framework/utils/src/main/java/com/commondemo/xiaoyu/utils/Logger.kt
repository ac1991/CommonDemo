package com.commondemo.xiaoyu.utils

import android.util.Log

/**
 * Created by sqwu on 2018/6/5.
 */
object Logger {
    var debug:Boolean = true
    var TAG = "CommonDemo "

    fun d(tag:String, msg:String) {
        if (debug){
            Log.d(TAG + tag, msg)
        }
    }

    fun i(tag:String, msg:String) {
        if (debug){
            Log.i(TAG + tag, msg)
        }
    }

    fun e(tag:String, msg:String) {
        if (debug){
            Log.e(TAG + tag, msg)
        }
    }

    fun w(tag:String, msg:String) {
        if (debug){
            Log.w(TAG + tag, msg)
        }
    }

    fun v(tag:String, msg:String) {
        if (debug){
            Log.v(TAG + tag, msg)
        }
    }
}