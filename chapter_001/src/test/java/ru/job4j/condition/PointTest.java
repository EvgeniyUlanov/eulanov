package ru.job4j.condition;

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

public class PointTest {

    /**
     * Test point belongs function.
     */

    @Test
    public void whenPointOnLineThenTrue() {
	Point a = new Point(1, 1);
	boolean rsl = a.is(0, 1);
	assertThat(rsl, is(true));

    }
}