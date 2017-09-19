package ru.job4j.start;

import java.util.ArrayList;

/**
 * class StubInput for tests.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class StubInput implements Input {
	/** answers. */
	private ArrayList<String> answers;
	/** position of answers. */
	private int position = 0;

	/**
	 * constructor StubInput.
	 * @param answers - answers.
	 */
	public StubInput(ArrayList<String> answers) {
		this.answers = answers;
	}

	/**
	 * metod ask.
	 * @param question - question.
	 * @return answer.
	 */
	public String ask(String question) {
		return answers.get(position++);
	}

	/**
	 * metod ask.
	 * @param question - question.
	 * @param range - range of valide answers.
	 * @return answer.
	 */
	public int ask(String question, ArrayList<Integer> range) {
		return Integer.valueOf(answers.get(position++));
	}
}