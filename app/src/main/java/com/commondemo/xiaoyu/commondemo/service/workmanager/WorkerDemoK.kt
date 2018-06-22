package com.commondemo.xiaoyu.commondemo.service.workmanager

import android.os.Looper
import android.widget.Toast
import androidx.work.Data
import androidx.work.Worker
import com.commondemo.xiaoyu.utils.Logger


/**
 * Created by Xiaoyu on 2018/6/14.
 */
class WorkerDemoK: Worker() {

    override fun doWork(): WorkerResult {
        val build = Data.Builder()
        build.putString("k2", "吃饭")
        outputData = build.build()

        Logger.e("WorkerDemoK传入值：", inputData.getString("k1","默认传入值 ")+ applicationContext.toString())

//        val toast = Toast(applicationContext, Looper.getMainLooper())

        return WorkerResult.SUCCESS
    }

}