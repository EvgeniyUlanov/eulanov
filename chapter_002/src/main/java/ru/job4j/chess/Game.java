package ru.job4j.chess;

/**
 * class Game.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Game {
	/** board.*/
	private Board board;
	/** input.*/
	private Input input;
	/**
	 * constructor.
	 * @param input - input.
	 * @param board - board.
	 */
	public Game(Input input, Board board) {
		this.board = board;
		this.input = input;
	}
	/**
	 * start metod.
	 */
	public void start() {
		boolean valide = false;
		do {
			System.out.println(board.showBoard());
			try {
				valide =
				board.move(board.getCell(input.ask("Sourse Cell x"), input.ask("Sourse Cell y")),
						   board.getCell(input.ask("Dest Cell x"), input.ask("Dest Cell y")));
			} catch (FigureNotFoundException fnfe) {
				System.out.println("Sourse Cell is empty, please enter correct Cell");
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Wrong Cell destanation");
			} catch (ImpossibleMoveException ime) {
				System.out.println("Wrong Turn.");
			} catch (OccupiedWayException owe) {
				System.out.println("The way is blocked.");
			}
		} while (!valide);
		System.out.println(board.showBoard());
	}
}