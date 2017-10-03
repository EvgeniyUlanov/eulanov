package ru.job4j.iterator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test class EvenIterator.
 */
public class EvenIteratorTest {
    /**
     * test method hasNext.
     */
    @Test
    public void ifIncomingArrayHasNextEvenNumberThanTrue() {
        int[] incoming = {2, 3, 4, 5};
        EvenIterator iter = new EvenIterator(incoming);

        iter.next();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }

    /**
     * test method next.
     */
    @Test
    public void ifMethodNextReturnOnlyEvenNumbersThanOk() {
        int[] incoming = {2, 3, 4, 5};
        EvenIterator iter = new EvenIterator(incoming);

        ArrayList<Integer> result = new ArrayList<>();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4));

        assertThat(result, is(expected));
    }

    /**
     * test next method exception.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenHaveNotNextEvenElementThanNextException() {
        int[] incoming = {3, 5, 4, 5};
        EvenIterator iter = new EvenIterator(incoming);

        iter.next();
        iter.next();
    }

}