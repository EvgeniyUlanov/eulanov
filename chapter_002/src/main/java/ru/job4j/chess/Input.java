package ru.job4j.chess;

import java.util.Scanner;

/**
 * class Input.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Input {
	/** scanner.*/
	private Scanner scanner = new Scanner(System.in);

	/**
	 * metod ask.
	 * @param question - question.
	 * @return int.
	 */
	public int ask(String question) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				System.out.println(question);
				value = Integer.valueOf(scanner.nextLine());
				invalid = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid Input");
			}
		} while (invalid);
		return value;
	}
}