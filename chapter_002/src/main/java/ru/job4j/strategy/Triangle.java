package ru.job4j.strategy;

/**
 * interface Triangle.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */

public class Triangle implements Shape {

	/**
	 * metod pic.
	 * @return string.
	 */
	public String pic() {
		StringBuilder str = new StringBuilder();
		str.append("   A   \n");
		str.append("  AAA  \n");
		str.append(" AAAAA \n");
		str.append("AAAAAAA");
		return str.toString();
	}
}