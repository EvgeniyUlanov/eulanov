package ru.ulanov.rpg;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(new Task());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 25;
    }
}
