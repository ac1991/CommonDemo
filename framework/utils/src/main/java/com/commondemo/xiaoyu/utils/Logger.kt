package com.commondemo.xiaoyu.utils

import android.util.Log

/**
 * Created by sqwu on 2018/6/5.
 */
object Logger {
    var debug:Boolean = true

    fun d(tag:String, msg:String) {
        if (debug){
            Log.d(tag, msg)
        }
    }

    fun i(tag:String, msg:String) {
        if (debug){
            Log.i(tag, msg)
        }
    }

    fun e(tag:String, msg:String) {
        if (debug){
            Log.e(tag, msg)
        }
    }

    fun w(tag:String, msg:String) {
        if (debug){
            Log.w(tag, msg)
        }
    }

    fun v(tag:String, msg:String) {
        if (debug){
            Log.v(tag, msg)
        }
    }
}