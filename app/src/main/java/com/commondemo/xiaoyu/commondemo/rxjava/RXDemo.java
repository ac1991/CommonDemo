package com.commondemo.xiaoyu.commondemo.rxjava;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

/**
 * Created by sqwu on 2018/8/21.
 * https://gank.io/post/560e15be2dca930e00da1083
 *
 * rxbind：
 * https://www.cnblogs.com/zhaoyanjun/p/5535651.html
 */

public class RXDemo {

    public static void demo1(){
        Observable observable  = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("吃鸡吧");
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s;
            }
        });

//        observable.su
    }
}
