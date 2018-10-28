package ru.job4j.chess;

/**
 * class Player.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Player {
	/** color.*/
	private int color;
	/**
	 * constructor.
	 * @param color - color;
	 */
	public Player(int color) {
		this.color = color;
	}

	/**
	 * metod getColor.
	 * @return color.
	 */
	public String getColor() {
		if (color == 1) {
			return "w";
		} else if (color == 2) {
			return "b";
		}
		return "getInstance";
	}
}