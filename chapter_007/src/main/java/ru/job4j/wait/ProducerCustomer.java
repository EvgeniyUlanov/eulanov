package ru.job4j.wait;

/**
 * class ProducerCustomer.
 */
public class ProducerCustomer {

    /** product.*/
    private boolean product = false;
    /** monitore.*/
    private final Object lock = new Object();

    /**
     * method produce.
     * @param prod - product.
     * @throws InterruptedException - InterruptedException.
     */
    public void produce(int prod) throws InterruptedException {
        synchronized (lock) {
            System.out.println("Locked by " + Thread.currentThread().getName());
            while (product) {
                System.out.println("Thread wait " + Thread.currentThread().getName());
                lock.wait();
            }
            product = true;
            System.out.println(String.format("Product %s was produced.", prod));
            System.out.println("Unlocked by " + Thread.currentThread().getName());
            lock.notifyAll();
        }
    }

    /**
     * method consume.
     * @throws InterruptedException - InterruptedException.
     */
    public void consume() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Locked by " + Thread.currentThread().getName());
            while (!product) {
                System.out.println("Thread wait " + Thread.currentThread().getName());
                lock.wait();
            }
            product = false;
            System.out.println("Product was consumed.");
            System.out.println("Unlocked by " + Thread.currentThread().getName());
            lock.notifyAll();
        }
    }

    /**
     * main method.
     * @param args - args.
     * @throws InterruptedException - InterruptException.
     */
    public static void main(String[] args) throws InterruptedException {
        ProducerCustomer producerCustomer = new ProducerCustomer();
        Thread producer = new Producer(producerCustomer);
        Thread customer = new Customer(producerCustomer);
        producer.setName("Producer");
        customer.setName("Customer");
        producer.start();
        customer.start();
        Thread.sleep(1000);
        producer.interrupt();
        customer.interrupt();
        System.out.println("Finish.");
    }
}

/**
 * class Producer.
 */
class Producer extends Thread {

    /** producerCustomer.*/
    private ProducerCustomer producerCustomer;

    /**
     * constructor.
     * @param producerCustomer - producerCustomer.
     */
    Producer(ProducerCustomer producerCustomer) {
        this.producerCustomer = producerCustomer;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        try {
            int i = 1;
            while (i <= 10) {
                producerCustomer.produce(i);
                i++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Tread Producer was Interrupted.");
        }
    }
}

/**
 * class Customer.
 */
class Customer extends Thread {

    /** producerCustomer.*/
    private ProducerCustomer producerCustomer;

    /**
     * constructor.
     * @param producerCustomer - producerCustomer.
     */
    Customer(ProducerCustomer producerCustomer) {
        this.producerCustomer = producerCustomer;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        try {
            int i = 0;
            while (i++ < 10) {
                producerCustomer.consume();
            }
        } catch (InterruptedException e) {
            System.out.println("Tread Customer was Interrupted.");
        }
    }
}
