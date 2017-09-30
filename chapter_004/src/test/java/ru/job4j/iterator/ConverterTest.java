package ru.job4j.iterator;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class for testing Convert class.
 */
public class ConverterTest {
    /**
     * test1.
     */
    @Test
    public void whenItHasTwoInnerIteratorsThanNextNextMetodReturnSecondIterNumber() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
            Collections.singletonList(1).iterator(),
            Collections.singletonList(2).iterator()
            ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        int result = convert.next();
        assertThat(result, is(2));
    }

    /**
     * test2.
     */
    @Test
    public void whenIteratorHasManyIteratorsThanNextReturnAllIteratorsValueAtAll() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 0));
        Iterator<Iterator<Integer>> it = Arrays.asList(list1.iterator(), list2.iterator()).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        ArrayList<Integer> result = new ArrayList<>();
        while (convert.hasNext()) {
            result.add(convert.next());
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        assertThat(result, is(expected));
    }
}
