package ru.job4j.chess;

/**
 * class MoveDiagonal.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class MoveDiagonal implements MoveBehavior {
	/** position.*/
	private Cell position;

	/**
	 * constructor.
	 * @param position - position.
	 */
	public MoveDiagonal(Cell position) {
		this.position = position;
	}

	/**
	 * metod way.
	 * @param dest - destanation cell.
	 * @return cell[].
	 */
	public Cell[] way(Cell dest) {
		boolean[] direct = this.direction(dest);
		int count = Math.abs(this.position.getX() - dest.getX());
		Cell[] path = new Cell[count];
		if (direct[0] && direct[1]) {
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX() + 1 + i, this.position.getY() + 1 + i);
			}
		}
		if (direct[0] && !direct[1]) {
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX() + 1 + i, this.position.getY() - 1 - i);
			}
		}
		if (!direct[0] && direct[1]) {
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX() - 1 - i, this.position.getY() + 1 + i);
			}
		}
		if (!direct[0] && !direct[1]) {
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX() - 1 - i, this.position.getY() - 1 - i);
			}
		}
		return path;
	}

	/**
	 * metod direction.
	 * @param dest - dest cell.
	 * @return boolean.
	 */
	public boolean[] direction(Cell dest) {
		boolean[] derect = new boolean[2];
		if (this.position.getX() <= dest.getX()) {
			derect[0] = true;
		} else {
			derect[0] = false;
		}
		if (this.position.getY() <= dest.getY()) {
			derect[1] = true;
		} else {
			derect[1] = false;
		}
		return derect;
	}
}