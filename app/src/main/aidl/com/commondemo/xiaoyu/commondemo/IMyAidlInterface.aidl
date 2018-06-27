// IMyAidlInterface.aidl
package com.commondemo.xiaoyu.commondemo;

import com.commondemo.xiaoyu.commondemo.service.AIDL.Person;
import com.commondemo.xiaoyu.commondemo.ICallBack;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void setPerson(in Person person);

    void setCallback(in ICallBack callback);
}
