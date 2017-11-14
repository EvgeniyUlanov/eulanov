package ru.job4j.wait;

import java.util.concurrent.locks.Lock;

public class MyLockTest {

    private int count;
    private Lock lock = new MyLock();

    public static void start() throws InterruptedException {
        MyLockTest test = new MyLockTest();
        Thread thread1 = new MyThread(test);
        Thread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        System.out.println("Starting interrupt.");
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(100);
        System.out.println("Finish");
    }

    void increment() throws InterruptedException {
            lock.lock();
            try {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                count++;
                System.out.println("Count was increast " + count + " by " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
    }

    int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}

class MyThread extends Thread {
    private boolean isStoped = false;
    private MyLockTest test;
    MyThread(MyLockTest test) {
        this.test = test;
    }
    @Override
    public void run() {
        while (!isStoped) {
            try {
                test.increment();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.format("Thread %s was interrupted\n", Thread.currentThread().getName());
                isStoped = true;
            }
        }
    }
}
