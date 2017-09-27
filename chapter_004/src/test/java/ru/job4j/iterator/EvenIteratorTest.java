package ru.job4j.iterator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test class EvenIterator.
 */
public class EvenIteratorTest {
    /**
     * test metod hasNext.
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
     * test metod next.
     * @throws Exception
     */
    @Test
    public void ifMetodNextReturnOnlyEvenNumbersThanOk() {
        int[] incoming = {2, 3, 4, 5};
        EvenIterator iter = new EvenIterator(incoming);

        ArrayList<Integer> result = new ArrayList<>();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{2, 4}));

        assertThat(result, is(expected));
    }

}