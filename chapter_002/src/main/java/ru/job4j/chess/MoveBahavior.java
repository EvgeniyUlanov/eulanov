package ru.job4j.chess;

/**
 * interface moveBehavior.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
interface MoveBehavior {

	/**
	 * metod way.
	 * @param dest - destanation cell.
	 * @return cell[] way.
	 */
	Cell[] way(Cell dest);
}