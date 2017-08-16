package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Tests for class Factorial.
 *
 * @author Evgeniy Ulanov
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {

    /**
     * Test metod calc with 0.
     */
	@Test
	public void whenNumberZeroFactrialOne() {
		Factorial fact = new Factorial();
		assertTrue(fact.calc(0) == 1);
	}

	/**
	 * Test metod calc with 5.
	 */
	@Test
	public void whenNumberFiveFactorialOneHandredTwenty() {
		Factorial fact = new Factorial();
		int result = fact.calc(5);
		int expected = 120;
		assertThat(result, is(expected));
	}
}