package com.commondemo.xiaoyu.utils.download;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

import com.commondemo.xiaoyu.utils.Logger;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件下载，非线程安全
 * Created by sqwu on 2018/8/2.
 * https://blog.csdn.net/xietansheng/article/details/52513624
 */
public class SQDownloadManager {

    private static SQDownloadManager mSQDownloadManager;
    private String filePath;

    public static List<Map<String, String>> downloadFiles = new ArrayList<Map<String, String>>();
    public static final String FILE_PATH = "file_path";
    public static final String FILE_ID = "file_id";

    private SQDownloadManager(){}

    public static SQDownloadManager getInstance(){
        if (mSQDownloadManager == null){
            synchronized (SQDownloadManager.class){
                if (mSQDownloadManager == null){
                    mSQDownloadManager = new SQDownloadManager();
                }
            }
        }
        return mSQDownloadManager;
    }

    public synchronized void download(@NotNull Context context,@NotNull String url, String title, String fileName){
        if (TextUtils.isEmpty(url) || context == null || TextUtils.isEmpty(fileName)){
            Toast.makeText(context, "download url、fileName or context is null", Toast.LENGTH_SHORT).show();
            Logger.INSTANCE.e(this.getClass().getSimpleName(), "download url、fileName or context is null");
            return ;
        }
        // 创建下载请求
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        File saveFile = new File(getFilePath(), fileName);
        request.setDestinationUri(Uri.fromFile(saveFile));
        /*
        * 2. 获取下载管理器服务的实例, 添加下载任务
        */
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        // 将下载请求加入下载队列, 返回一个下载ID
        long downloadId = manager.enqueue(request);

        //保存下载id和路径
        Map<String, String> map= new HashMap<String, String>();
        map.put(FILE_PATH, getFilePath() + File.separator + fileName);
        map.put(FILE_ID, downloadId + "");
        downloadFiles.add(map);

    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    private String getFilePath(){
        if (!TextUtils.isEmpty(filePath)){
            File file = new File(filePath);

            if (file.exists()){
                return filePath;
            }else {
                file.mkdirs();
            }
            return filePath;
        }

        boolean sdExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdExist){
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }else{
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
    }


}
