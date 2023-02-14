package com.niuzj.model;

public class TestWait {

    private final Object lock;

    public TestWait(Object lock) {
        this.lock = lock;
    }

    public void testWait() throws InterruptedException {
        synchronized (lock) {
            lock.wait();
            System.out.println("test wait");

        }
    }

    /**
     * Object 的wait, notify等方法只有该对象为锁对象时才有用
     */
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            try {
                new TestWait(lock).testWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("...");
        //这里需要休眠一会儿,避免notify方法比wait方法执行早
        Thread.sleep(100L);
        synchronized (lock) {
            lock.notify();

        }


    }
}
