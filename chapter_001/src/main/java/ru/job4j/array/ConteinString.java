package ru.job4j.array;

/**
 * class ConteinString.
 *
 * @author Evgeniy Ulanov (komrad1812@yamndex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class ConteinString {

	/**
	 * metod contein return true if
	 * origin string conteins sub string.
	 * @param origin - origin string.
	 * @param sub - sub string.
	 * @return true/false.
	 */

	public boolean contein(String origin, String sub) {
	char[] string = new char[origin.length()];
		char[] sequence = new char[sub.length()];
		for (int i = 0; i < origin.length(); i++) {
			string[i] = origin.charAt(i);
		}
		for (int i = 0; i < sub.length(); i++) {
			sequence[i] = sub.charAt(i);
		}
		boolean cont = false;
		for (int i = 0; i <= string.length - sequence.length; i++) {
			for (int j = 0; j < sequence.length; j++) {
				if (string[i + j] == sequence[j]) {
					cont = true;
				} else {
					cont = false;
				}
			}
			if (cont) {
				return cont;
			}
		}
		return cont;
	}

}