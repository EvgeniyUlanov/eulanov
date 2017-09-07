package ru.job4j.chess;

/**
 * class Slon - extends Figure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Slon extends Figure {

	/**
	 * constructor.
	 * @param start - cell were figure set.
	 */
	public Slon(Cell start) {
		super(start);
	}

	/**
	 * metod valideMove - checks correct move.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean valideMove(Cell dest) {
		this.setMoveBehavior(new MoveDiagonal(this.getPosition()));
		int xPos = Math.abs(dest.getX() - this.getPosition().getX());
		int yPos = Math.abs(dest.getY() - this.getPosition().getY());
		if (xPos == yPos) {
			return true;
		}
		return false;
	}

	/**
	 * metod show.
	 * @return String.
	 */
	public String show() {
		return "S";
	}
}