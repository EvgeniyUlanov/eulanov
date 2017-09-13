package ru.job4j.chess2;

/**
 * class MoveLikeHorse.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class MoveLikeHorse implements MoveBehavior {
	/** position.*/
	private Cell position;

	/**
	 * constructor.
	 * @param position - position.
	 */
	public MoveLikeHorse(Cell position) {
		this.position = position;
	}

	/**
	 * metod way.
	 * @param dest - destanation cell.
	 * @return cell[].
	 */
	public Cell[] way(Cell dest) {
		Cell[] path = {dest};
		return path;
	}
}