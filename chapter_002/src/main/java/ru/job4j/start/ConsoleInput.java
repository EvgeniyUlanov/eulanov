package ru.job4j.start;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * class ConsoleInput.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class ConsoleInput implements Input {
	/** scanner in. */
	private Scanner scanner = new Scanner(System.in);

	/**
	 * metod ask.
	 * @param question - question.
	 * @return user answer.
	 */
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}

	/**
	 * metod ask.
	 * @param question - question.
	 * @param range - range of valid answers.
	 * @return user answer.
	 */
	@Override
	public int ask(String question, List<Integer> range)  {
		int key = Integer.valueOf(this.ask(question));
		if (range.contains(key)) {
			return key;
		} else {
			throw new MenuOutException("Invalide menu number");
		}
	}
}