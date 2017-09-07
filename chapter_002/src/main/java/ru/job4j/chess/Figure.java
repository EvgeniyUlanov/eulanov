package ru.job4j.chess;

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
		this.position.setFigure(this);
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
		this.position.setFigure(this);
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
	 * @param cells - cells.
	 * @return boolean.
	 */
	public boolean clearPath(Cell dest, Cell[][] cells) {
		boolean clear = true;
		if (this.valideMove(dest)) {
			Cell[] path = this.moveBehavior.way(dest);
			for (Cell cell : path) {
				cell = cells[cell.getX()][cell.getY()];
				if (!cell.isEmpty()) {
					clear = false;
					break;
				}
			}
		} else {
			throw new ImpossibleMoveException("Wrog turn");
		}
		return clear;
	}

	/**
	 * metod show.
	 * @return string.
	 */
	abstract String show();
}