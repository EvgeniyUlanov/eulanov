package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class tests SimpleArray class.
 */
public class SimpleArrayTest {

    /**
     * test for metod add, get.
     * @throws WrongPositionException - exception.
     */
    @Test
    public void whenAddValueThanConteinerHaveThisElement() throws WrongPositionException {
        SimpleArray<String> simple = new SimpleArray<>();

        simple.add("test");

        assertThat(simple.get(0), is("test"));
    }

    /**
     * test for metod delete.
     * @throws WrongPositionException - exception.
     */
    @Test
    public void whenDeleteValueThanThisConteinerDoesNotConteinThisElement() throws WrongPositionException {
        SimpleArray<String> simple = new SimpleArray<>();

        simple.add("test one");
        simple.add("test two");
        simple.add("test tree");
        simple.delete(1);

        assertThat(simple.get(1), is("test tree"));
    }

    /**
     * test for metod update.
     * @throws WrongPositionException - exception.
     */
    @Test
    public void whenUpdateValueThanConteinerUpdateElement() throws WrongPositionException {
        SimpleArray<String> simple = new SimpleArray<>();

        simple.add("test one");
        simple.add("test two");
        simple.add("test tree");
        simple.update(1, "test four");

        assertThat(simple.get(1), is("test four"));
    }

    /**
     * test wrong position.
     * @throws WrongPositionException - exception.
     */
    @Test (expected = WrongPositionException.class)
    public void whenPositionIsWrongThanException() throws WrongPositionException {
        SimpleArray<String> simple = new SimpleArray<>();

        simple.add("test");
        simple.get(3);
    }
}
