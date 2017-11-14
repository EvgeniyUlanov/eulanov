package ru.job4j.wait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProdCustWithMyLock extends ProducerCustomer {

    /** product.*/
    private boolean product = false;
    /** monitor.*/
    private Lock lock = new MyLock();
    private Condition cond = lock.newCondition();

    /**
     * method produce.
     * @param prod - product.
     * @throws InterruptedException - InterruptedException.
     */
    public void produce(int prod) throws InterruptedException {
        lock.lock();
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
        try {
            while (product) {
                cond.await();
            }
            product = true;
            System.out.println(String.format("Product %s was produced by %s.", prod, Thread.currentThread().getName()));
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * method consume.
     * @throws InterruptedException - InterruptedException.
     */
    public void consume() throws InterruptedException {
        lock.lock();
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
        try {
            while (!product) {
                cond.await();
            }
            product = false;
            System.out.println("Product was consumed by " + Thread.currentThread().getName());
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * method start.
     * @throws InterruptedException - InterruptedException.
     */
    public static void start() throws InterruptedException {
        ProducerCustomer producerCustomer = new ProdCustWithMyLock();
        Thread producer = new Producer(producerCustomer);
        Thread customer = new Customer(producerCustomer);
        producer.setName("Producer");
        customer.setName("Customer");
        producer.start();
        customer.start();
        Thread.sleep(400);
        System.out.println("");
        System.out.println("Starting interrupt.");
        producer.interrupt();
        customer.interrupt();
        Thread.sleep(100);
    }

    /**
     * main method.
     * @param args - args.
     * @throws InterruptedException - InterruptException.
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start.");
        try {
            start();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }
        System.out.println("Finish.");
    }
}
