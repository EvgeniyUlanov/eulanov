package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class SlonTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class SlonTest {

	/**
	 * test for wrong move.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenSlonMovedToWrongDestThanInvalideMoveException() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[2][0]);
		Board board = new Board(cells);
		board.move(board.getCell(2, 0), board.getCell(0, 0));
	}

	/**
	 * test for right move.
	 */
	public void whenSlonMovedRightDestThanFigureMoved() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[2][0]);
		Board board = new Board(cells);
		assertThat(board.getCell(2, 0).isEmpty(), is(false));
		assertThat(board.getCell(0, 2).isEmpty(), is(true));
		board.move(board.getCell(2, 0), board.getCell(0, 2));
		assertThat(board.getCell(0, 2).isEmpty(), is(false));
	}

	/**
	 * test for cell is empty.
	 */
	@Test (expected = FigureNotFoundException.class)
	public void whenSourseCellIsEmptyThanFigureNotFoundException() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[2][0]);
		Board board = new Board(cells);
		board.move(board.getCell(5, 5), board.getCell(4, 4));
	}

	/**
	 * test for way is locked.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenWayIsOccupiedThanOccupiedWayException() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Board board = new Board(cells);
		Player player = new Player(1);
		Figure slon = new Slon(cells[2][0]);
		slon.setPlayer(player);
		Figure slon2 = new Slon(cells[3][1]);
		slon2.setPlayer(player);
		board.move(board.getCell(2, 0), board.getCell(4, 2));
	}
}