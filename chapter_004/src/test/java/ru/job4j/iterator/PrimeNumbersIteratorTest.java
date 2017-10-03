package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class tests PrimeNumbersIterator.
 */
public class PrimeNumbersIteratorTest {
    /**
     * test hasNext metod.
     */
    @Test
    public void metodHasNextReturnsIfExistNextPrimeNumberTrueElseFalse() {
        PrimeNumbersIterator iter = new PrimeNumbersIterator(new int[]{1, 2, 4, 5, 6, 8});

        assertThat(iter.hasNext(), is(true));

        iter.next();
        iter.next();

        assertThat(iter.hasNext(), is(false));
    }
    /**
     * test next metod.
     */
    @Test
    public void whenNextThanIteratorReturnPrimeNumber() {
        PrimeNumbersIterator iter = new PrimeNumbersIterator(new int[]{1, 2, 4, 5, 6, 8, 11});

        iter.next();

        assertThat(iter.next(), is(5));
        assertThat(iter.next(), is(11));
    }
    /**
     * test method next exception.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenHaveNotNextPrimeNumberThanNextReturnException() {
        PrimeNumbersIterator iter = new PrimeNumbersIterator(new int[]{11});

        iter.next();
        iter.next();
    }
}
