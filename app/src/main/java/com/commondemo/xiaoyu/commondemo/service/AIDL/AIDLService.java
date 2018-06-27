package com.commondemo.xiaoyu.commondemo.service.AIDL;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.commondemo.xiaoyu.commondemo.ICallBack;
import com.commondemo.xiaoyu.commondemo.IMyAidlInterface;
import com.commondemo.xiaoyu.utils.Logger;

/**
 * Created by 吴升旗 on 2018/6/23.
 */

/**
 1.创建 AIDL
 1.创建要操作的实体类，实现 Parcelable 接口，以便序列化/反序列化
 2.新建 aidl 文件夹，在其中创建接口 aidl 文件以及实体类的映射 aidl 文件
 3.Make project ，生成 Binder 的 Java 文件

 2.服务端
 1.创建 Service，在其中创建上面生成的 Binder 对象实例，实现接口定义的方法
 2.在 onBind() 中返回

 3.客户端
 1.实现 ServiceConnection 接口，在其中拿到 AIDL 类
 2.bindService()
 3.调用 AIDL 类中定义好的操作请求
 */
public class AIDLService extends Service{
    static final String TAG = "AIDLService";
    static ICallBack mCallback = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.INSTANCE.i("AIDLService", "onBind pid:" + Process.myPid() + "   ThreadName:" + Thread.currentThread().getName());

        return mIBinder;
    }

    //内部非主线程
    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setPerson(Person person) throws RemoteException {
            Logger.INSTANCE.i(TAG + "   ThreadName:" + Thread.currentThread().getName(), person.toString());
            if (mCallback != null){
                mCallback.onCallback(person);
            }
        }

        @Override
        public void setCallback(ICallBack callback) throws RemoteException {
            mCallback = callback;
        }
    };


}
