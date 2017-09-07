package ru.job4j.chess;

/**
 * class MoveDiagonal.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class MoveStraight implements MoveBehavior {
	/** position.*/
	private Cell position;

	/**
	 * constructor.
	 * @param position - position.
	 */
	public MoveStraight(Cell position) {
		this.position = position;
	}

	/**
	 * metod way.
	 * @param dest - destanation cell.
	 * @return cell[].
	 */
	public Cell[] way(Cell dest) {
		int count;
		Cell[] path = new Cell[0];
		if (this.position.getX() == dest.getX() && this.position.getY() < dest.getY()) {
			count = Math.abs(this.position.getY() - dest.getY());
			path = new Cell[count];
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX(), this.position.getY() + 1 + i);
			}
			return path;
		}
		if (this.position.getX() == dest.getX() && this.position.getY() > dest.getY()) {
			count = Math.abs(this.position.getY() - dest.getY());
			path = new Cell[count];
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX(), this.position.getY() - 1 - i);
			}
			return path;
		}
		if (this.position.getX() < dest.getX() && this.position.getY() == dest.getY()) {
			count = Math.abs(this.position.getX() - dest.getX());
			path = new Cell[count];
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX() + 1 + i, this.position.getY());
			}
			return path;
		}
		if (this.position.getX() > dest.getX() && this.position.getY() == dest.getY()) {
			count = Math.abs(this.position.getX() - dest.getX());
			path = new Cell[count];
			for (int i = 0; i < count; i++) {
				path[i] = new Cell(this.position.getX() - 1 - i, this.position.getY());
			}
			return path;
		}
		return path;
	}
}