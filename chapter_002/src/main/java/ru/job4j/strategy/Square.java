package ru.job4j.strategy;

/**
 * interface Square.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */

public class Square implements Shape {

	/**
	 * metod pic.
	 * @return string.
	 */
	public String pic() {
		StringBuilder str = new StringBuilder();
		str.append("+------+\n");
		str.append("|      |\n");
		str.append("|      |\n");
		str.append("|      |\n");
		str.append("+------+");
		return str.toString();
	}
}