package com.commondemo.xiaoyu.commondemo.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.commondemo.xiaoyu.commondemo.R
import com.commondemo.xiaoyu.commondemo.lifecycle.BaseActivity
import com.commondemo.xiaoyu.utils.Logger
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 博客地址：https://www.jianshu.com/p/0fda3132cf98
 */
class RetrofitActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        retrofit()
    }

    fun retrofit(){
        /**
         * create里面通过动态代理去创建server
         * create中有个ServiceMethod对象，通过它去做注解的解析生成http协议数据
         */
        val net = NetManager.getInstance().creatYJ<SQServer>(SQServer::class.java)
        net.serverList.enqueue(object :Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                Logger.i("RetrofitActivity, response", response!!.body()!!.string());
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {

            }

        })
    }

    fun retrofit1(){
        val net = NetManager.getInstance().creatYJ<SQServer>(SQServer::class.java)
        net.serverList1.enqueue(object :Callback<Test1Model>{
            override fun onResponse(call: Call<Test1Model>?, response: Response<Test1Model>?) {
                Logger.i("RetrofitActivity, response", response!!.body()!!.code.toString());
            }

            override fun onFailure(call: Call<Test1Model>?, t: Throwable?) {

            }

        })
    }
}
