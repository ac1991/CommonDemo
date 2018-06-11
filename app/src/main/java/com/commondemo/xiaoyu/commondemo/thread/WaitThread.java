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

//        runnableThread();

//        yeild();

//        join();

        join1();
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

    /**
     * yield，
     * 让出时间片，所有线程重新竞争时间片
     */
    private static void yeild(){
        ThreadYield yt1 = new ThreadYield("张三");
        ThreadYield yt2 = new ThreadYield("李四");
        yt1.start();
        yt2.start();

    }

    /**
     * join为Thread的方法，用于在启动子线程之后，保活父线程，执行完子线程之后才继续执行start方法之后的父线程逻辑
     */
    private static void join(){
        System.out.println("主线程开启");
        AThread thread1 = new AThread();
        thread1.setName("线程1");
        AThread thread2 = new AThread();
        thread2.setName("线程2");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }

    private static void join1(){
        JoinThread joinThread = new JoinThread();
        joinThread.start();
    }

}

class AThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            WaitThread.index++;
            System.out.println(getName() + ": " + WaitThread.index);
        }
    }
}

class JoinThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("线程开启");
        AThread thread = new AThread();
        thread.setName("线程1");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束");
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

/**
 * Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作，从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。
 * 从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。相应的notify()就是对对象锁的唤醒操作。
 * 但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
 * 这样就提供了在线程间同步、唤醒的操作。Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。
 */
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


class ThreadYield extends Thread{
    public ThreadYield(String name) {
                super(name);
            }

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                       System.out.println("" + this.getName() + "-----" + i);
                        // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
                        if (i ==30) {
                                this.yield();
                            }
                    }

        }
}

