package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeniy Ulanov
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {

    /**
     * Test add.
     */

    @Test
    public void whenFromOneToTenThenSumThirty() {
		Counter counter = new Counter();
		int result = counter.add(1, 10);
		int expected = 30;
		assertThat(result, is(expected));
    }
}