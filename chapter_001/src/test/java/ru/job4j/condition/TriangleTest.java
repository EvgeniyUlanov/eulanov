package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test triangle.
 *
 * @author Evgeniy Ulanov.
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {

	/**
	 * Test triangle.
	 */
	@Test
	public void whenAreaSetThreePointsThenTriangleArea() {
		/** Create point a. */
		Point a = new Point(0, 0);
		/** Create point b. */
		Point b = new Point(0, 2);
		/** Create point c. */
		Point c = new Point(2, 0);
		/** Create triangle. */
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.square();
		double expected = 2D;

		assertThat(result, is(closeTo(expected, 0.1)));

	}


}