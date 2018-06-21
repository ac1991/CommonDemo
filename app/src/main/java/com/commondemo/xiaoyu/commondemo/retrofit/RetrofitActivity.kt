package com.commondemo.xiaoyu.commondemo.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.commondemo.xiaoyu.commondemo.R
import com.commondemo.xiaoyu.commondemo.lifecycle.BaseActivity
import okhttp3.ResponseBody
import retrofit2.Callback

class RetrofitActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
    }

    fun retrofit(){
        val net = NetManager.getInstance().creatYJ<SQServer>(SQServer::class.java)
//        net.serverList.enqueue(Callback<ResponseBody>)
    }
}
