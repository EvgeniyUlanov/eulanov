package ru.job4j.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class for testing SimpleLinkedList.
 */
public class SimpleLinkedListTest {
    /**
     * test add, get metods.
     */
    @Test
    public void whenAddValueToListThanListConteinThatValue() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();

        list.add("test");
        list.add("test1");

        assertThat(list.get(1), is("test1"));
    }

    /**
     * test for iterator.
     */
    @Test
    public void whenListHaveElementsThanCicleForReturnAllElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        list.add(10);
        list.add(11);
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10, 11));
        for (Integer i : list) {
            result.add(i);
        }

        assertThat(result, is(expected));
    }
}
