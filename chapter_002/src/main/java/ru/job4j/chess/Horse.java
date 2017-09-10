package ru.job4j.chess;

/**
 * class Horse - extends Figure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Horse extends Figure {

	/**
	 * constructor.
	 * @param start - cell were figure set.
	 */
	public Horse(Cell start) {
		super(start);
	}

	/**
	 * metod valideMove - checks correct move.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean valideMove(Cell dest) {
		this.setMoveBehavior(new MoveLikeHorse(this.getPosition()));
		int xPos = Math.abs(dest.getX() - this.getPosition().getX());
		int yPos = Math.abs(dest.getY() - this.getPosition().getY());
		if ((xPos == 2) && (yPos == 1)) {
			return true;
		} else if ((yPos == 2) && (xPos == 1)) {
			return true;
		}
		return false;
	}

	/**
	 * metod show.
	 * @return String.
	 */
	public String show() {
		return "H";
	}
}