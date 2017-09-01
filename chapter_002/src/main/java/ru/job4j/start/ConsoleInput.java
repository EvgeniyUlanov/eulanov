package ru.job4j.start;

import java.util.Scanner;

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
	public int ask(String question, int[] range)  {
		int key = Integer.valueOf(this.ask(question));
		boolean contein = false;
		for (int value : range) {
			if (value == key) {
				contein = true;
				break;
			}
		}
		if (contein) {
			return key;
		} else {
			throw new MenuOutException("Invalide menu number");
		}
	}
}