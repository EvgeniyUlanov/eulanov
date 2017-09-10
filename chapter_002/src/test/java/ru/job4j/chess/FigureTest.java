package ru.job4j.chess;

import org.junit.Test;

/**
 * class FigureTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

 public class FigureTest {

	/**
	 * test if destanation cell is position cell than exeption.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenCellDestEqualsPositionCellThanImpossibleMoveException() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure queen = new Queen(cells[2][1]);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(2, 1));
	}
}