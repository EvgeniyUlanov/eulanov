package ru.job4j.loop;

/**
 * class Board create board.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {

	/**
	 * metod paintBoard return String.
	 * @param width - width of board.
	 * @param height - height of board.
	 * @return string.
	 */
	public String paintBoard(int width, int height) {
		StringBuilder desk = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((i + j) % 2 == 0) {
					desk.append("X");
				} else {
					desk.append(" ");
				}
			}
			desk.append("\r\n");
		}
		return desk.toString();
	}
}