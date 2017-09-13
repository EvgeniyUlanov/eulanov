package ru.job4j.chess2;

/**
 * class Tura - extends Figure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Tura extends Figure {

	/**
	 * constructor.
	 * @param start - cell were figure set.
	 */
	public Tura(Cell start) {
		super(start);
	}

	/**
	 * metod valideMove - checks correct move.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean valideMove(Cell dest) {
		this.setMoveBehavior(new MoveStraight(this.getPosition()));
		if ((dest.getX() == this.getPosition().getX())
				|| (dest.getY() == this.getPosition().getY())) {
			return true;
		}
		return false;
	}
}