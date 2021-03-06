package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class ConteinString.
 *
 * @author Evgeniy Ulanov.
 * @version $Id$
 * @since 0.1
 */

public class ConteinStringTest {

	/**
	 * Test for metod contein.
	 * return true if origin string conteins sub string
	 */

	@Test
	public void whenOriginStringConteinSubReturnTrue() {
		ConteinString str = new ConteinString();
		boolean result = str.contein("Hello", "lo");
		boolean expected = true;
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod contein.
	 * return false if origin string don't  conteins sub string
	 */

	@Test
	public void whenOriginStringNotConteinSubReturnFalse() {
		ConteinString str = new ConteinString();
		boolean result = str.contein("Hello", "olo");
		boolean expected = false;
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod contein.
	 * return false if origin string smaller than sub string
	 */

	@Test
	public void whenOriginStringSmallerThanSubReturnFalse() {
		ConteinString str = new ConteinString();
		boolean result = str.contein("ol", "Hello");
		boolean expected = false;
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod contein.
	 * return false if sub string empty.
	 */

	@Test
	public void whenSubSringEmptyReturnFalse() {
		ConteinString str = new ConteinString();
		boolean result = str.contein("Hello", "");
		boolean expected = false;
		assertThat(result, is(expected));
	}
}