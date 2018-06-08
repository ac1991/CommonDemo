package com.commondemo.xiaoyu.commondemo.thread;

/**
 * Created by Xiaoyu on 2018/6/7.
 */

public class WaitThread {
    /**
     * 加volatile保证可见性
     */
    public static volatile int index = 0;

    public static void main(String[] args){
        System.out.println("打印日志");
//        VisibleThread();

        runnableThread();
    }

    /**
     * 多线程共享变量
     */
    private static void VisibleThread(){
        for (int i = 0; i< 10; i++){
            AThread thread = new AThread();
            thread.setName("Thread" + i);
            thread.start();
        }
    }

    /**
     * 多线程共享runnable
     */
    private static void runnableThread(){
        ARunnable runnable = new ARunnable();
        for (int i = 0; i< 10; i++){
            Thread thread = new Thread(runnable);
            thread.setName("Thread" + i);
            thread.start();
        }
    }

}

class AThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            WaitThread.index++;
            System.out.println(getName() + ": " + WaitThread.index);
        }
    }
}

/**
 * 测试runnable
 */
class ARunnable implements Runnable {
    private static volatile int index = 0;
    @Override
    public void run() {
        for (int i = 0; i< 10; i++){
            index++;
            System.out.println(Thread.currentThread().getName() + ": " + index);
        }
    }
}

class Service {

              public void testMethod(Object lock) {
                 try {
                         synchronized (lock) {
                                System.out.println("begin wait() ThreadName="
                                                 + Thread.currentThread().getName());
                                lock.wait();
                                System.out.println("  end wait() ThreadName="
                                                 + Thread.currentThread().getName());
                             }
                     } catch (InterruptedException e) {
                                  e.printStackTrace();
                     }
             }

             public void synNotifyMethod(Object lock) {
                 try {
                         synchronized (lock) {
                                 System.out.println("begin notify() ThreadName="
                                                 + Thread.currentThread().getName() + " time="
                                                 + System.currentTimeMillis());
                                 lock.notify();
                                 Thread.sleep(5000);
                                 System.out.println("  end notify() ThreadName="
                                                 + Thread.currentThread().getName() + " time="
                                                 + System.currentTimeMillis());
                             }
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
             }
 }