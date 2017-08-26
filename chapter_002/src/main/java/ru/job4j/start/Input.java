package ru.job4j.start;

/**
 * interface Input.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public interface Input {
	/**
	 * metod ask.
	 * @param question - question.
	 * @return answer.
	 */
	String ask(String question);
}