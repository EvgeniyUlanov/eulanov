package ru.job4j.start;

import java.util.List;

/**
 * class ValidateInput.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class ValidateInput extends ConsoleInput {

	/**
	 * metod ask.
	 * @param question - question.
	 * @param range - range of valid answers.
	 * @return user answer.
	 */
	@Override
	public int ask(String question, List<Integer> range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (NumberFormatException nfe) {
				TrackerIO.getInstance().out("Invalid input. It must be number from 1 to 7.");
			} catch (MenuOutException moe) {
				TrackerIO.getInstance().out("The number must be from 1 to 7.");
			}
		} while (invalid);
		return value;
	}
}