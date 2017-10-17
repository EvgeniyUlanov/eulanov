package ru.job4j.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class SimpleBinaryTreeTest.
 */
public class SimpleBinaryTreeTest {

    /**
     * test add method.
     */
    @Test
    public void whenAddValueThatDoesNotExistInTreeThanTrueElseFalse() {
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();

        tree.add("Andrey");

        assertThat(tree.add("Bred"), is(true));
        assertThat(tree.add("Andrey"), is(false));
    }

    /**
     * test iterator method.
     */
    @Test
    public void addtest() {
        SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>();

        tree.add(5);
        tree.add(7);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer value : tree) {
            result.add(value);
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        assertThat(result, is(expected));
    }
}
