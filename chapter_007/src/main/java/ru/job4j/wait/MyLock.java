package ru.job4j.wait;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * class MyLock.
 */
public class MyLock implements Lock {
    /** monitor.*/
    private final Object lock = new Object();
    /** boolean isLocked.*/
    private boolean isLocked;
    /** myLock.*/
    private MyLock myLock = this;

    /**
     * method lock.
     */
    @Override
    public void lock() {
        boolean interrupt = false;
        synchronized (lock) {
            while (isLocked && !interrupt) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupt exception - " + Thread.currentThread().getName());
                    interrupt = true;
                }
            }
            if (interrupt) {
                Thread.currentThread().interrupt();
            } else {
                isLocked = true;
            }
        }
    }

    /**
     * method lockInterruptibly.
     * @throws InterruptedException - InterruptedException.
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
        synchronized (lock) {
            while (isLocked) {
                lock.wait();
            }
            isLocked = true;
        }
    }

    /**
     * method tryLock.
     * @return - boolean.
     */
    @Override
    public boolean tryLock() {
        boolean result;
        if (isLocked) {
            result = false;
        } else {
            lock();
            result = true;
        }
        return result;
    }

    /**
     * metod tryLock.
     * @param time - time to wait.
     * @param unit - time unit.
     * @return boolean.
     * @throws InterruptedException - InterruptedException.
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        boolean result = false;
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
        long timeStart = System.currentTimeMillis();
        while ((System.currentTimeMillis() - timeStart) < unit.toMillis(time)) {
            if (isLocked) {
                Thread.sleep(10);
            } else {
                result = true;
                lock();
            }
        }
        return result;
    }

    /**
     * method unlock.
     */
    @Override
    public void unlock() {
        synchronized (lock) {
            isLocked = false;
            lock.notifyAll();
        }
    }

    /**
     * method newCondition.
     * @return Condition.
     */
    @Override
    public Condition newCondition() {
        return new Condition() {

            private boolean wasSignal;

            @Override
            public void await() throws InterruptedException {
                synchronized (lock) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    myLock.isLocked = false;
                    lock.wait();
                }
            }

            @Override
            public void awaitUninterruptibly() {
                synchronized (lock) {
                    while (!wasSignal) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Someone try to interrupt the thread.");
                        }
                    }
                }
            }

            @Override
            public long awaitNanos(long nanosTimeout) throws InterruptedException {
                synchronized (lock) {
                    lock.wait(nanosTimeout / 1000000);
                    return 0; //не совсем понял, что должен возвращать метод.
                }
            }

            @Override
            public boolean await(long time, TimeUnit unit) throws InterruptedException {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                lock.wait(unit.toMillis(time));
                return true;
            }

            @Override
            public boolean awaitUntil(Date deadline) throws InterruptedException {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                wait(deadline.getTime() - System.currentTimeMillis());
                return true;
            }

            @Override
            public void signal() {
                wasSignal = true;
                myLock.isLocked = false;
                lock.notify();
            }

            @Override
            public void signalAll() {
                synchronized (lock) {
                    wasSignal = true;
                    myLock.isLocked = false;
                    lock.notifyAll();
                }
            }
        };
    }
}