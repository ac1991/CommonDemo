package com.commondemo.xiaoyu.commondemo.service.AIDL

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import com.commondemo.xiaoyu.commondemo.ICallBack
import com.commondemo.xiaoyu.commondemo.IMyAidlInterface
import com.commondemo.xiaoyu.commondemo.R
import com.commondemo.xiaoyu.commondemo.lifecycle.BaseActivity
import com.commondemo.xiaoyu.utils.Logger
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : BaseActivity() {

    var aidl:IMyAidlInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        aidlInit()
        initView()
    }

    fun initView(){
        aidl_button.setOnClickListener {
            val person = Person()
            person.name = "小胖纸"
            person.age = 26
            aidl?.setPerson(person)
        }

        messenger_button.setOnClickListener(){

        }
    }

    /**
     * bind启动注意unbind
     */
    private fun aidlInit(){

        val intent = Intent(this, AIDLService::class.java)
        bindService(intent,object :ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                //连接后拿到 Binder，转换成 AIDL，在不同进程会返回个代理
                aidl = IMyAidlInterface.Stub.asInterface(service)
                aidl?.setCallback(AIDLCallback())
            }

            override fun onServiceDisconnected(name: ComponentName?) {

            }
        }, Context.BIND_AUTO_CREATE)

    }

    class AIDLCallback: ICallBack.Stub() {
        override fun onCallback(person: Person?) {
            Logger.i("ServiceActivity threadName:" + Thread.currentThread().name, person.toString())
        }
    }
}
