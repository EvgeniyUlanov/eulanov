package ru.job4j.testtask;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class tests SortCodeArray.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */
public class SortCodeArrayTest {
    /**
     * test for metod sortIncrease.
     */
    @Test
    public void whenMetodSortIncreaseTakeArrayThanReturnSortedArrayByIncrease() {
        ArrayList<String> incoming = new ArrayList<>();
        incoming.add("K1\\SK1");
        incoming.add("K1\\SK1\\SSK1");
        incoming.add("K1\\SK1\\SSK2");
        incoming.add("K2");
        incoming.add("K2\\SK1\\SSK1");
        incoming.add("K2\\SK1\\SSK2");
        ArrayList<String> result = SortCodeArray.sortIncrease(incoming);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K1");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K2\\SK1\\SSK2");
        assertThat(result, is(expected));
    }
    /**
     * test for metod sortDecrease.
     */
    @Test
    public void whenMetodSortDecreaseTakeArrayThanReturnSortedArrayByDecrease() {
        ArrayList<String> incoming = new ArrayList<>();
        incoming.add("K1\\SK1");
        incoming.add("K1\\SK1\\SSK1");
        incoming.add("K1\\SK1\\SSK2");
        incoming.add("K2");
        incoming.add("K2\\SK1\\SSK1");
        incoming.add("K2\\SK1\\SSK2");
        ArrayList<String> result = SortCodeArray.sortDecrease(incoming);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK2");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K1");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K1\\SK1\\SSK1");
        assertThat(result, is(expected));
    }
}
