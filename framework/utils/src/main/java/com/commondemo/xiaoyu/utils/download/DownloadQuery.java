package com.commondemo.xiaoyu.utils.download;

import android.app.DownloadManager;
import android.content.Context;

/**
 * Created by Xiaoyu on 2018/8/2.
 */

public class DownloadQuery {

    public static final String getDownloadPath(Context context, long[] ids){
        // 获取下载管理器服务的实例
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        // 创建一个查询对象
        DownloadManager.Query query = new DownloadManager.Query();

        // 根据 下载ID 过滤结果
        query.setFilterById(ids);

        // 还可以根据状态过滤结果
         query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL);

        return null;
    }
}
