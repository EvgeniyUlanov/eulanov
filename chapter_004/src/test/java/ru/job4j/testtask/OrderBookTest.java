package ru.job4j.testtask;

import org.junit.Test;

/**
 * class OrderBookTest.
 */
public class OrderBookTest {

    /**
     * test2.
     */
    @Test
    public void test2() {
        Order order1 = new Order(1, "SELL", 10F, 300);
        Order order2 = new Order(2, "SELL", 11F, 100);
        Order order4 = new Order(4, "SELL", 11F, 20);
        Order order3 = new Order(3, "BUY", 9F, 50);
        Order order5 = new Order(5, "BUY", 10F, 50);
        Order order6 = new Order(6, "BUY", 8F, 100);
        Order order7 = new Order(7, "BUY", 12F, 200);
        OrderBook book = new OrderBook("1");

        book.add(order6);
        book.add(order1);
        book.add(order2);
        book.add(order3);
        book.add(order4);
        book.add(order5);
        book.add(order7);
        book.delete(1);
        book.show();
    }
}


