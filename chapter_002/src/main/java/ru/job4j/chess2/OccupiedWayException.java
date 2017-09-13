package ru.job4j.chess2;

/**
 * class Board.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
class OccupiedWayException extends RuntimeException {
	/**
	 * constructor.
	 * @param msg - message.
	 */
	OccupiedWayException(String msg) {
		super(msg);
	}
}