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
	/** player number.*/
	private Player player;

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
		if (this.position.equalsCell(dest)) {
			throw new ImpossibleMoveException("Wrog turn");
		}
		boolean clear = true;
		if (this.valideMove(dest)) {
			Cell[] path = this.moveBehavior.way(dest);
			for (int i = 0; i < path.length - 1; i++) {
				path[i] = cells[path[i].getX()][path[i].getY()];
				if (!path[i].isEmpty()) {
					clear = false;
				}
			}
			if (clear && !dest.isEmpty() && dest.getFigure().getPlayer() != this.getPlayer()) {
				clear = true;
			} else if (clear && dest.isEmpty()) {
				clear = true;
			} else {
				clear = false;
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

	/**
	 * metod return player.
	 * @return player.
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * metod setPlayer.
	 * @param player - player;
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
}