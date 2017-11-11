package ru.job4j.wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * class ThreadPool.
 */
public class ThreadPool {
    /** task queue.*/
    private BlockingQueue<Work> taskQueue;
    /** list of threads.*/
    private List<SimpleThread> threads = new ArrayList<>();
    /** boolean is stoped.*/
    private boolean isStoped = false;

    /**
     * constructor.
     */
    ThreadPool() {
        int maxThreadNumber = Runtime.getRuntime().availableProcessors();
        this.taskQueue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < maxThreadNumber; i++) {
            threads.add(new SimpleThread(taskQueue));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    /**
     * method add - add new work.
     * @param work- work to add.
     * @throws InterruptedException - Interrupted exception.
     */
    public void add(Work work) throws InterruptedException {
        if (isStoped) {
            throw new IllegalStateException();
        }
        taskQueue.put(work);
    }

    /**
     * method stopThreadPool - stops all threads.
     */
    public void stopThreadPool() {
        isStoped = true;
        for (SimpleThread thread : threads) {
            thread.stopThread();
        }
    }
}

/**
 * class SimpleThread.
 */
class SimpleThread extends Thread {
    /** boolean stoped.*/
    private boolean stoped = false;
    /** work queue.*/
    private BlockingQueue<Work> worksQueue;

    /**
     * constructor.
     * @param worksQueue - work queue.
     */
    SimpleThread(BlockingQueue<Work> worksQueue) {
        this.worksQueue = worksQueue;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!stoped) {
            try {
                worksQueue.take().doWork();
            } catch (InterruptedException e) {
                System.out.println(String.format("%s was interrupted.", thread.getName()));
            }
        }
        System.out.println(String.format("%s finish all works.", thread.getName()));
    }

    /**
     * method stopThread.
     */
    void stopThread() {
        this.stoped = true;
        this.interrupt();
    }
}

/**
 * class Work.
 */
class Work {
    /** name of work.*/
    private String name;

    /**
     * constructor.
     * @param name - name of work.
     */
    Work(String name) {
        this.name = name;
    }

    /**
     * method doWork - do something.
     * @throws InterruptedException - Interrupted exception.
     */
    void doWork() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("Work %s was made by %s", name, threadName));
        Thread.sleep(100);
    }

    /**
     * method getName.
     * @return name.
     */
    String getName() {
        return name;
    }
}
