package ru.job4j.chess2;

/**
 * class Horse - extends Figure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Horse extends Figure {
	/** move straigth.*/
	private final int straigth = 2;
	/** move sideaway.*/
	private final int sideaway = 1;

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
		if ((xPos == straigth) && (yPos == sideaway)) {
			return true;
		} else if ((yPos == straigth) && (xPos == sideaway)) {
			return true;
		}
		return false;
	}
}