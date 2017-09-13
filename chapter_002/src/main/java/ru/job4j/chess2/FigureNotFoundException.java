package ru.job4j.chess2;

/**
 * class Board.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
class FigureNotFoundException extends RuntimeException {
	/**
	 * constructor.
	 * @param msg - message.
	 */
	FigureNotFoundException(String msg) {
		super(msg);
	}
}