package ru.job4j.chess;

/**
 * class Chess.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */

public class Chess {
	/**
	 * main metod.
	 * @param args - param.
	 */
	public static void main(String[] args) {
		Input input = new Input();
		System.out.println("Chess");
		Game game = new Game(input);
		boolean end = false;
		do {
			game.start();
			if (input.ask("for surrender choose 1") == 1) {
				end = true;
			}
		} while (!end);
	}
}