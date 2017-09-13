package ru.job4j.chess2;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TuraTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class TuraTest {

	/**
	 * test impossible move.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenPawnMovedWrongDestThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Tura(cells[2][1])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(2, 1), board.getCell(3, 3));
	}

	/**
	 * test can move straight right, left, up, down.
	 */
	@Test
	public void whenTuraMovedStraightThanTrue() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Tura(cells[2][1])};
		Board board = new Board(cells, figures);
		// Tura moving down.
		assertThat(board.move(board.getCell(2, 1), board.getCell(2, 3)), is(true));
		// Tura moving up.
		assertThat(board.move(board.getCell(2, 3), board.getCell(2, 1)), is(true));
		// Tura moving right.
		assertThat(board.move(board.getCell(2, 1), board.getCell(7, 1)), is(true));
		// Tura moving left.
		assertThat(board.move(board.getCell(7, 1), board.getCell(0, 1)), is(true));
	}

	/**
	 * test cannot move throw another figure.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenTuraMoveThrowAnotherFigureThanOccupiedWayExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Tura(cells[4][0]),
							new Pawn(cells[4][5], true)};
		Board board = new Board(cells, figures);
		board.move(board.getCell(4, 0), board.getCell(4, 7));
	}
}