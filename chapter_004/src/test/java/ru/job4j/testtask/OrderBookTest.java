package ru.job4j.testtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class OrderBookTest.
 */
public class OrderBookTest {
    /**
     * test method add, findById.
     */
    @Test
    public void whenAddNewOrderThanThisOrderExistThisOrder() {
        Order order1 = new Order(1, "SELL", 10F, 300);
        OrderBook book = new OrderBook("1");

        book.add(order1);

        assertThat(book.findById(1), is(order1));
    }

    /**
     * test method add, if exist sell order, that if add buy order this the same price.
     * and lower volume, than sell order decrease volume, and buy order is closed(dn't add in the book).
     * anather side is the same.
     */
    @Test
    public void whenAddOrderWithAnotherTypeAndSamePriceThanDeletingLowestVolumeAndDecreaseHighestVolume() {
        Order order1 = new Order(1, "SELL", 10F, 300);
        Order order2 = new Order(2, "BUY", 10F, 50);
        Order order3 = new Order(3, "BUY", 10F, 300);
        OrderBook book = new OrderBook("1");

        book.add(order1);
        book.add(order2);
        Order result = null;

        assertThat(book.findById(1).getVolume(), is(250));
        assertThat(book.findById(2), is(result));

        book.add(order3);

        assertThat(book.findById(3).getVolume(), is(50));
        assertThat(book.findById(1), is(result));
    }

    /**
     * test method delete.
     */
    @Test
    public void whenDeleteOrderFromBookThanBookIsEmpty() {
        Order order1 = new Order(1, "SELL", 10F, 300);
        Order order2 = new Order(2, "SELL", 11F, 100);
        Order order3 = new Order(3, "SELL", 11F, 20);
        OrderBook book = new OrderBook("1");

        book.add(order1);
        book.delete(1);

        assertThat(book.isEmpty(), is(true));

        book.add(order2);
        book.add(order3);

        assertThat(book.findById(2), is(order2));

        book.delete(2);
        Order result = null;

        assertThat(book.findById(2), is(result));
    }

    /**
     * test method show.
     */
    @Test
    public void testMethodShow() {
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


