package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test for simple array list.
 */
public class SimpleArrayListTest {

    /**
     * test for metod add, get and conteiner can increase size.
     */
    @Test
    public void whenAddLastElementThanArrayIncrease() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>(2);

        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.get(2), is(3));
    }
}
