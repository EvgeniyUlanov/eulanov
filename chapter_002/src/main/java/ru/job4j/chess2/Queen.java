package ru.job4j.chess2;

/**
 * class Queen - extends Figure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Queen extends Figure {

	/**
	 * constructor.
	 * @param start - cell were figure set.
	 */
	public Queen(Cell start) {
		super(start);
	}

	/**
	 * metod valideMove - checks correct move.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean valideMove(Cell dest) {
		if (Math.abs(dest.getX() - this.getPosition().getX())
		 == Math.abs(dest.getY() - this.getPosition().getY())) {
			this.setMoveBehavior(new MoveDiagonal(this.getPosition()));
			return true;
		} else if ((dest.getX() == this.getPosition().getX())
				|| (dest.getY() == this.getPosition().getY())) {
			this.setMoveBehavior(new MoveStraight(this.getPosition()));
			return true;
		}
		return false;
	}
}