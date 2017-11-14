package ru.job4j.wait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdCustWithMyLock extends ProducerCustomer {

    /** product.*/
    private boolean product = false;
    /** monitore.*/
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
        System.out.println("");
    }

    /**
     * method consume.
     * @throws InterruptedException - InterruptedException.
     */
    public void consume() throws InterruptedException {
        lock.lock();
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
        System.out.println("");
    }

    /**
     * main method.
     * @param args - args.
     * @throws InterruptedException - InterruptException.
     */
    public static void main(String[] args) throws InterruptedException {
        ProducerCustomer producerCustomer = new ProdCustWithMyLock();
        Thread producer = new Producer(producerCustomer);
        Thread customer = new Customer(producerCustomer);
        producer.setName("Producer");
        customer.setName("Customer");
        producer.start();
        customer.start();
        Thread.sleep(500);
        System.out.println("Starting interrupt.");
        producer.interrupt();
        customer.interrupt();
        System.out.println("Finish.");
    }
}
