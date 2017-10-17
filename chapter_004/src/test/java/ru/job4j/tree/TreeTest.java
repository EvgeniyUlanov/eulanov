package ru.job4j.tree;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TreeTest.
 */
public class TreeTest {

    /**
     * test add, method add cannot add duplicate.
     */
    @Test
    public void whenAddThanResultTrueIfTreeConteinValueThanResultFalse() {
        Tree<String> tree = new Tree<>();

        tree.add("one", "two");
        tree.add("two", "tree");
        tree.add("one", "four");
        tree.add("two", "five");
        tree.add("one", "five");

        assertThat(tree.add("one", "six"), is(true));
        assertThat(tree.add("five", "six"), is(false));

        for (String str : tree) {
            System.out.println(str);
        }
    }

    /**
     * test iterator.
     */
    @Test
    public void cycleForReturnAllOfTreeElements() {
        Tree<String> tree = new Tree<>();

        tree.add("one", "two");
        tree.add("two", "tree");
        tree.add("one", "four");
        tree.add("two", "five");
        tree.add("one", "five");

        for (String str : tree) {
            System.out.println(str);
        }
    }

    /**
     * test exception.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenHasNotParentThanAddThrowException() {
        Tree<String> tree = new Tree<>();

        tree.add("one", "two");
        tree.add("two", "tree");
        tree.add("one", "four");
        tree.add("two", "five");
        tree.add("one", "five");
        tree.add("six", "seven");
    }

    /**
     * test is Binary.
     */
    @Test
    public void ifTreeIsBinaryThanResultIsTrueElseFalse() {
        Tree<String> tree = new Tree<>();

        tree.add("one", "two");
        tree.add("one", "tree");
        tree.add("two", "four");
        tree.add("two", "five");

        assertThat(tree.isBinary(), is(true));

        tree.add("one", "six");

        assertThat(tree.isBinary(), is(false));
    }
}
