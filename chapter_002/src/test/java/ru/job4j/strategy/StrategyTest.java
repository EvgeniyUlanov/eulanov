package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class StrategyTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class StrategyTest {
	/**
	 * test to draw triangle.
	 */
	@Test
	public void whenUseTriangleMetodDrawTriangle() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Paint paint = new Paint(new Triangle());
		paint.draw();
		assertThat(out.toString(), is(String.format("   A   \n  AAA  \n AAAAA \nAAAAAAA")));
	}

	/**
	 * test to draw square.
	 */
	@Test
	public void whenUseSquareMetodDrawSquare() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Paint paint = new Paint(new Square());
		paint.draw();
		assertThat(out.toString(), is(String.format("+------+\n|      |\n|      |\n|      |\n+------+")));
	}

}