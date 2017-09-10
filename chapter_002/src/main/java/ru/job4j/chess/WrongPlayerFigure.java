package ru.job4j.chess;

/**
 * class WrongPlayerFigure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
class WrongPlayerFigure extends RuntimeException {

	/**
	 * constructor.
	 * @param msg - message.
	 */
	WrongPlayerFigure(String msg) {
		super(msg);
	}
}