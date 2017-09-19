package ru.job4j.start;

import java.util.ArrayList;

/**
 * interface Input.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public interface Input {
	/**
	 * metod ask return string.
	 * @param question - question.
	 * @return answer - string.
	 */
	String ask(String question);

	/**
	 * metod ask return int.
	 * @param question - question.
	 * @param range - range of valide answers.
	 * @return answer - int.
	 */
	int ask(String question, ArrayList<Integer> range);
}