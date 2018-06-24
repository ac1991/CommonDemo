package com.commondemo.xiaoyu.commondemo.service.workmanager;


import android.support.annotation.NonNull;
import android.widget.Toast;

import com.commondemo.xiaoyu.utils.Logger;

import java.util.HashMap;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * Created by Xiaoyu on 2018/6/13.
 */

public class WorkerDemo extends Worker{
    @NonNull
    @Override
    public WorkerResult doWork() {
        Logger.INSTANCE.d(this.getClass().getName(), Thread.currentThread().getName() + ":doWork");

        Data.Builder builder = new Data.Builder();
        builder.putBoolean("k1", true);
        builder.putString("k2", "吃饭");
        setOutputData(builder.build());
        return WorkerResult.SUCCESS;
    }
}
