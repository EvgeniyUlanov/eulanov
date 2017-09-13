package ru.job4j.chess2;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class QueenTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class QueenTest {

	/**
	 * test impossible move.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenQueenMovedWrongDestThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Queen(cells[2][1])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(2, 1), board.getCell(3, 3));
	}

	/**
	 * test can move diagonal and straight.
	 */
	@Test
	public void whenQueenMovedInRightDirectionThanDirectionCellReturnQueen() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Queen(cells[4][4])};
		Board board = new Board(cells, figures);
		// Queen moving left.
		assertThat(board.move(board.getCell(4, 4), board.getCell(1, 4)), is(true));
		// Queen moving right.
		assertThat(board.move(board.getCell(1, 4), board.getCell(4, 4)), is(true));
		// Queen moving down.
		assertThat(board.move(board.getCell(4, 4), board.getCell(4, 7)), is(true));
		// Queen moving up.
		assertThat(board.move(board.getCell(4, 7), board.getCell(4, 4)), is(true));
		// Queen moving leftdown.
		assertThat(board.move(board.getCell(4, 4), board.getCell(2, 6)), is(true));
		// Queen moving rightup.
		assertThat(board.move(board.getCell(2, 6), board.getCell(4, 4)), is(true));
		// Queen moving leftup.
		assertThat(board.move(board.getCell(4, 4), board.getCell(2, 2)), is(true));
		// Queen moving rightdown.
		assertThat(board.move(board.getCell(2, 2), board.getCell(4, 4)), is(true));
	}

	/**
	 * test cannot move throw another figure.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenQueenMoveThrowAnotherFigureThanOccupiedWayExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Queen(cells[4][4]),
							new Tura(cells[1][4])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(4, 4), board.getCell(0, 4));
	}
}