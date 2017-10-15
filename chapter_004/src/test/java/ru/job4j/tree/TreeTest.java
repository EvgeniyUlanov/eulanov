package ru.job4j.tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * class TreeTest.
 */
public class TreeTest {
    @Test
    public void test1() {
        Tree<String> tree = new Tree<>();
        tree.add("one", "two");
        tree.add("two","tree");
        for (String str : tree) {
            System.out.println(str);
        }
    }
}
