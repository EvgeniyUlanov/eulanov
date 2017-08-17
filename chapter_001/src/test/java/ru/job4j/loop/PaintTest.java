package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Paint.
 *
 * @author Evgeniy Ulanov
 * @version $Id$
 * @since 0.1
 */

public class PaintTest {

	/**
	 * test paintPyramid with width 2.
	 */
	@Test
	public void whenHeigthTwoThenWidthThree() {
		Paint pyramid = new Paint();
		String result = pyramid.paintPyramid(2);
		final String line = System.getProperty("line.separator");
		String expected = String.format(" A %sAAA%s", line, line);
		assertThat(result, is(expected));
	}

	/**
	 * test paintPyramid with width 3.
	 */
	@Test
	public void whenHeigthThreeThenWidthFive() {
		Paint pyramid = new Paint();
		String result = pyramid.paintPyramid(3);
		final String line = System.getProperty("line.separator");
		String expected = String.format("  A  %s AAA %sAAAAA%s", line, line, line);
		assertThat(result, is(expected));
	}

	/**
	 * test checks that will not create pramid with zero.
	 */

	@Test
	public void whenHeigthNegativThenFailureToCreate() {
		Paint pyramid = new Paint();
		String result = pyramid.paintPyramid(0);
		String expected = "height mast be > 0";
		assertThat(result, is(expected));
	}

	/**
	 * test checks that will not create pramid with negativ number.
	 */
	@Test
	public void whenHeigthZeroThenFailureToCreate() {
		Paint pyramid = new Paint();
		String result = pyramid.paintPyramid(-5);
		String expected = "height mast be > 0";
		assertThat(result, is(expected));
	}
}