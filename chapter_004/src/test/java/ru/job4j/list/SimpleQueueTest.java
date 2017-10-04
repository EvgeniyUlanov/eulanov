package ru.job4j.list;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test for class SimpleQueue.
 */
public class SimpleQueueTest {
    /**
     * test push and poll.
     */
    @Test
    public void whenQueueHasElementsThanPollReturnFirstValue() {
        SimpleQueue<String> queue = new SimpleQueue<>();

        queue.push("test1");
        queue.push("test2");
        queue.push("test3");

        assertThat(queue.poll(), is("test1"));
    }

    /**
     * test for exception.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenQueueHasNotElementsThanPollReturnException() {
        SimpleQueue<String> queue = new SimpleQueue<>();

        queue.push("test1");
        queue.poll();
        queue.poll();
    }
}
