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
            while (product) {
                lock.wait();
            }
            product = true;
            System.out.println(String.format("Product %s was produced.", prod));
            lock.notifyAll();
        }
    }

    /**
     * method consume.
     * @throws InterruptedException - InterruptedException.
     */
    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (!product) {
                lock.wait();
            }
            product = false;
            System.out.println("Product was consumed.");
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
        producer.start();
        customer.start();
        Thread.sleep(2000);
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
