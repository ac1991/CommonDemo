package com.commondemo.xiaoyu.commondemo.service.workmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.commondemo.xiaoyu.commondemo.R
import kotlinx.android.synthetic.main.activity_worker.*

class WorkerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker)
        initView()
    }

    fun initView(){
        worker.setOnClickListener(){
            testOneTime()
        }
    }

    /**
     * worker在子线程中执行任务
     */
    fun testOneTime(){
        val workerRequest:OneTimeWorkRequest = OneTimeWorkRequest.Builder(WorkerDemo::class.java).build()
        WorkManager.getInstance().enqueue(workerRequest)
    }
}
