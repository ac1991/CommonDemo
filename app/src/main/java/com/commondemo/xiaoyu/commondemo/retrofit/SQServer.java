package com.commondemo.xiaoyu.commondemo.retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Xiaoyu on 2018/6/21.
 */

public interface SQServer {
    @GET(Constant.URL_SERVICE_LIST)
    Call<ResponseBody> getServerList();

    @GET(Constant.URL_SERVICE_LIST)
    Call<Test1Model> getServerList1();

}


