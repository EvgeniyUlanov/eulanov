package ru.job4j.max;

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

public class MaxTest {

    /**
     * Test max.
     */

    @Test
    public void showMaxValue() {
	Max maxvalue = new Max();
	int result = maxvalue.max(5, 6);
	int expected = 6;
	assertThat(result, is(expected));

    }
}