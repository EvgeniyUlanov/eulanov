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
}