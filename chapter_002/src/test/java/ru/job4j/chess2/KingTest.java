package ru.job4j.chess2;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class KingTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class KingTest {

	/**
	 * test impossible move.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenKingMovedWrongDestThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new King(cells[2][1])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(2, 1), board.getCell(4, 3));
	}

	/**
	 * test can move diagonal and straight.
	 */
	@Test
	public void whenKingMovedInRightDirectionThanDirectionCellReturnKing() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new King(cells[4][4])};
		Board board = new Board(cells, figures);
		// King moving left.
		assertThat(board.move(board.getCell(4, 4), board.getCell(3, 4)), is(true));
		// King moving right.
		assertThat(board.move(board.getCell(3, 4), board.getCell(4, 4)), is(true));
		// King moving down.
		assertThat(board.move(board.getCell(4, 4), board.getCell(4, 5)), is(true));
		// King moving up.
		assertThat(board.move(board.getCell(4, 5), board.getCell(4, 4)), is(true));
		// King moving leftdown.
		assertThat(board.move(board.getCell(4, 4), board.getCell(3, 5)), is(true));
		// King moving rightup.
		assertThat(board.move(board.getCell(3, 5), board.getCell(4, 4)), is(true));
		// King moving leftup.
		assertThat(board.move(board.getCell(4, 4), board.getCell(3, 3)), is(true));
		// King moving rightdown.
		assertThat(board.move(board.getCell(3, 3), board.getCell(4, 4)), is(true));
	}

	/**
	 * test cannot move throw another figure.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenKingMoveThrowAnotherFigureThanOccupiedWayExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new King(cells[4][4]),
							new Tura(cells[4][3])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(4, 4), board.getCell(4, 3));
	}

	/**
	 * test king can move only 1 cell straight.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenKingMovedTwoCellsStraightThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new King(cells[2][1])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(2, 1), board.getCell(4, 1));
	}

	/**
	 * test king can move only 1 cell diagonal.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenKingMovedTwoCellsDiagonalThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new King(cells[2][1])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(2, 1), board.getCell(4, 3));
	}
}