package com.commondemo.xiaoyu.commondemo.service.workmanager

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.commondemo.xiaoyu.commondemo.R
import com.commondemo.xiaoyu.utils.Logger
import kotlinx.android.synthetic.main.activity_worker.*
import java.util.concurrent.TimeUnit

/**
 * 1.WorkManager chooses the appropriate way to run your task based on such factors as the device API level and the app state.
 * If WorkManager executes one of your tasks while the app is running, WorkManager can run your task in a new thread in your app's process.
 * If your app is not running, WorkManager chooses an appropriate way to schedule a background task--depending on the device API level and
 * included dependencies, WorkManager might use JobScheduler, Firebase JobDispatcher, or AlarmManager. You don't need to write device logic
 * to figure out what capabilities the device has and choose an appropriate API; instead, you can just hand your task off to WorkManager
 * and let it choose the best option.
 *
 * 2.doWork在子线程中运行
 *
 */
class WorkerActivity : AppCompatActivity() {
    var workerRequest:OneTimeWorkRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker)
        initView()
    }

    fun initView(){

        worker.setOnClickListener(){
            testOneTime()
        }

        periodicWork.setOnClickListener(){
            testPeriodicWorkRequest()
        }
    }

    /**
     * worker在子线程中执行任务
     */
    fun testOneTime() {

        val workerRequest = OneTimeWorkRequest.Builder(WorkerDemoK::class.java).setInputData(Data.Builder().putString("k1", "吃鸡").build()).build()

        WorkManager.getInstance().enqueue(workerRequest)

        WorkManager.getInstance().getStatusById(workerRequest.id).observe(this , Observer<WorkStatus> {
            workStatus->{
            if (workStatus != null && workStatus.state.isFinished()) {
                Logger.e(this::class.java.simpleName, workStatus.outputData.getString("k2","默认数据"));
            }
        }
        });
    }

    fun testPeriodicWorkRequest(){
        val workRequest = PeriodicWorkRequest.Builder(WorkerDemoK::class.java, 12, TimeUnit.SECONDS).setInputData(Data.Builder().putString("k1", "吃鸭").build()).build()
        WorkManager.getInstance().enqueue(workRequest)
        WorkManager.getInstance().getStatusById(workRequest!!.id).observe(this , Observer<WorkStatus> {
            workStatus->{
            if (workStatus != null && workStatus.state.isFinished()) {
                Logger.e(this::class.java.simpleName, workStatus.outputData.getString("k2","默认数据"));
            }
        }
        });
    }
}
