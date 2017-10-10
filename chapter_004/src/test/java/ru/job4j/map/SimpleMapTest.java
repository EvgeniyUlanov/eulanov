package ru.job4j.map;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class SimpleMapTest.
 */
public class SimpleMapTest {

    /**
     * test insert.
     */
    @Test
    public void whenInsertKeyValueThanGetKeyReturnValue() {
        SimpleMap<String, String> map = new SimpleMap<>();

        map.insert("One", "One");
        map.insert("Second", "Second");

        assertThat(map.get("One"), is("One"));
        assertThat(map.insert("One", "Tree"), is(false));
    }

    /**
     * test get.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenKeyValueNotExistThanException() {
        SimpleMap<String, String> map = new SimpleMap<>();

        map.insert("One", "One");
        map.insert("Second", "Second");

        assertThat(map.get("Tree"), is("One"));
    }

    /**
     * test delete.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenDeleteValueThanThisValueNotExist() {
        SimpleMap<String, String> map = new SimpleMap<>();

        map.insert("One", "One");
        map.insert("Second", "Second");
        map.delete("One");
        map.get("One");
    }

    /**
     * test iterator.
     */
    @Test
    public void iteratorPrintAllValue() {
        SimpleMap<String, String> map = new SimpleMap<>();

        map.insert("One", "First");
        map.insert("Two", "Second");
        map.insert("Tree", "Third");
        map.insert("Four", "Firth");
        for (String str : map) {
            System.out.println(str);
        }
    }
}
