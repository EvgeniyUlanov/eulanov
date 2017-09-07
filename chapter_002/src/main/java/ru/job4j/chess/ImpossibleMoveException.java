package ru.job4j.chess;

/**
 * class ImpossibleMoveException.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
class ImpossibleMoveException extends RuntimeException {

	/**
	 * constructor.
	 * @param msg - message.
	 */
	ImpossibleMoveException(String msg) {
		super(msg);
	}
}