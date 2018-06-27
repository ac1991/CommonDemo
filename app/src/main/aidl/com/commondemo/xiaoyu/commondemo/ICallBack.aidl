// ICallBack.aidl
package com.commondemo.xiaoyu.commondemo;

// Declare any non-default types here with import statements
import com.commondemo.xiaoyu.commondemo.service.AIDL.Person;

interface ICallBack {
    void onCallback(in Person person);
}
