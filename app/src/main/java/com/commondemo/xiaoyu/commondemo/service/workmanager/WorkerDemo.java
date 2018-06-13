package com.commondemo.xiaoyu.commondemo.service.workmanager;


import android.support.annotation.NonNull;
import android.widget.Toast;

import com.commondemo.xiaoyu.utils.Logger;

import androidx.work.Worker;

/**
 * Created by Xiaoyu on 2018/6/13.
 */

public class WorkerDemo extends Worker{
    @NonNull
    @Override
    public WorkerResult doWork() {
        Logger.INSTANCE.d(this.getClass().getName(), Thread.currentThread().getName() + ":doWork");
        return WorkerResult.SUCCESS;
    }
}
