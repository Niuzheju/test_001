package com.niuzj.test;

/**
 *  Thread.yield();方法
 *  使当前线程让出cpu的执行权,并使当前线程进入就绪状态,然后所有线程重新争抢cpu执行权
 */
public class Test3 {
    public static void main(String[] args) {
        new YieldThread("hello1").start();
        new YieldThread("hello2").start();
    }
}

class YieldThread extends Thread{

    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "_" + i);
            if (i == 30){
                Thread.yield();
            }
        }
    }
}
