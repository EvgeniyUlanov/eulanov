package ru.job4j.list;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test for class SimpleStack.
 */
public class SimpleStackTest {
    /**
     * test.
     */
    @Test
    public void whenStackHasElementThanPolleReturnLastAddedElementAndDeleteIt() {
        SimpleStack<String> stack = new SimpleStack<>();

        stack.push("test1");
        stack.push("test2");
        assertThat(stack.poll(), is("test2"));
        assertThat(stack.poll(), is("test1"));
    }

    /**
     * test exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenStackDoesNotHaveElementThanPollReturnException() {
        SimpleStack<String> stack = new SimpleStack<>();

        stack.push("test");
        stack.poll();
        stack.poll();
    }
}
