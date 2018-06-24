package com.commondemo.xiaoyu.commondemo.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Xiaoyu on 2018/6/21.
 */

public class NetManager {
    private static NetManager net;
    private Retrofit retrofit;

    private NetManager(){
        init1();
    }

    public static NetManager getInstance(){
        if (net == null){
            synchronized (NetManager.class){
                if (net == null){
                    net = new NetManager();
                }
            }
        }
        return net;
    }

    /**
     * 不对返回结果做GSON解析
     */
    private void init(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Constant.baseUrl);
        retrofit = builder.build();
    }

    /**
     * 对返回结果做Gson解析
     */
    private void init1(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Constant.baseUrl);
        builder.addConverterFactory(GsonConverterFactory.create(new Gson()));
        retrofit = builder.build();
    }

    public <T> T creatYJ(Class clasz){
        return (T) retrofit.create(clasz);
    }
}
