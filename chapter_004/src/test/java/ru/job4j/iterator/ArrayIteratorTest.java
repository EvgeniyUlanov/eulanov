package ru.job4j.iterator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class tests ArrayIterator.
 */
public class ArrayIteratorTest {
    /**
     * test checks hasNext.
     */
    @Test
    public void whileIncommingArrayHasElementsThanIteratorHasNextReturnTrue() {
        ArrayIterator iter = new ArrayIterator(new int[][]{{1}});

        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }

    /**
     * test checks next.
     */
    @Test
    public void whileHasNextIsTrueThanNextReturnInteger() {
        int[][] incoming = {{1, 2}, {3, 4}};
        ArrayIterator iter = new ArrayIterator(incoming);

        ArrayList<Integer> result = new ArrayList<>();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.addAll(Arrays.asList(1, 2, 3, 4));

        assertThat(result, is(expected));
    }

    /**
     * test check exception.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenNextElementDoesNotExistNextWillGenerateException() {
        ArrayIterator iter = new ArrayIterator(new int[][]{{1}});

        iter.next();
        iter.next();
    }
}