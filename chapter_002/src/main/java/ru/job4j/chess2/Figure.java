package ru.job4j.chess2;

/**
 * class Figure - abstract class for all figures.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
abstract class Figure {
	/** cell were figure is. */
	private Cell position;
	/** movebehavior.*/
	private MoveBehavior moveBehavior;

	/**
	 * constructor.
	 * @param start - cell were figure set.
	 */
	Figure(Cell start) {
		this.position = start;
	}

	/**
	 * metod getPosition.
	 * @return position.
	 */
	public Cell getPosition() {
		return this.position;
	}

	/**
	 * metod setMoveBehavior.
	 * @param moveBehavior - movebehavior.
	 */
	public void setMoveBehavior(MoveBehavior moveBehavior) {
		this.moveBehavior = moveBehavior;
	}

	/**
	 * metod cloneTo.
	 * @param dest - cell were need to place figure.
	 */
	public void cloneTo(Cell dest) {
		this.position = dest;
	}

	/**
	 * metod canMove - checks move.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	abstract boolean valideMove(Cell dest);

	/**
	 * metod cleanPath - checks path.
	 * @param dest - destanation cell.
	 * @param figures - figures.
	 * @return boolean.
	 */
	public boolean clearPath(Cell dest, Figure[] figures) {
		if (this.position.equalsCell(dest)) {
			throw new ImpossibleMoveException("Wrog turn");
		}
		boolean clear = true;
		if (this.valideMove(dest)) {
			Cell[] path = this.moveBehavior.way(dest);
			for (int i = 0; i < path.length; i++) {
				for (Figure figure : figures) {
					if (figure.getPosition().equalsCell(path[i])) {
						return false;
					}
				}
			}
		} else {
			throw new ImpossibleMoveException("Wrog turn");
		}
		return clear;
	}
}