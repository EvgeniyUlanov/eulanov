package ru.job4j.set;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class SimpleLinkedSetTest.
 */
public class SimpleLinkedSetTest {
    /**
     * test that adding only original elements.
     */
    @Test
    public void whenAddingNewElementThatAlreadyInSetThanAddingIsNotHappen() {
        SimpleLinkedSet<String> simpleSet = new SimpleLinkedSet<>();

        simpleSet.add("test1");
        simpleSet.add("test2");
        simpleSet.add("test1");
        ArrayList<String> result = new ArrayList<>();
        for (String str : simpleSet) {
            result.add(str);
        }
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("test1", "test2"));

        assertThat(result, is(expected));
    }
}
