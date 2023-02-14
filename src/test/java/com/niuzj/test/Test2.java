package com.niuzj.test;

/**
 * thread的join方法
 * 在一个线程中开启一个子线程并调用子线程的join方法
 * 会阻塞主线程直到子线程执行完毕
 */
public class Test2 {
    public static void main(String[] args) {
        new Thread(new Parent()).start();

    }
}

class Parent implements Runnable{

    @Override
    public void run() {
        Son son = new Son();
        Thread thread = new Thread(son);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Parent");

    }
}

class Son implements Runnable{

    @Override
    public void run() {
        System.out.println("son");

    }
}
