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
	 * test impossible move.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenSlonMovedWrongDestThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[2][1]);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(2, 2));
	}

	/**
	 * test can move diagonal and straight.
	 */
	@Test
	public void whenSlonMovedInRightDirectionThanDirectionCellReturnSlon() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[4][4]);
		Board board = new Board(cells);
		// slon in target Cell.
		assertThat(board.getCell(4, 4).getFigure(), is(slon));
		// slon moving leftdown.
		board.move(board.getCell(4, 4), board.getCell(2, 6));
		assertThat(board.getCell(2, 6).getFigure(), is(slon));
		// slon moving rightup.
		board.move(board.getCell(2, 6), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(slon));
		// slon moving leftup.
		board.move(board.getCell(4, 4), board.getCell(2, 2));
		assertThat(board.getCell(2, 2).getFigure(), is(slon));
		// slon moving rightdown.
		board.move(board.getCell(2, 2), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(slon));
	}

	/**
	 * test Slon can eat enemy figure.
	 */
	@Test
	public void whenSlonEatEnemyFigureThanSlonMovingToEnemyCell() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[4][4]);
		Figure pawn = new Pawn(cells[2][2], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		slon.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 4), board.getCell(2, 2));
		assertThat(board.getCell(2, 2).getFigure(), is(slon));
	}

	/**
	 * test cannot move throw another figure.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenSlonMoveThrowAnotherFigureThanOccupiedWayExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure slon = new Slon(cells[4][4]);
		Figure tura = new Tura(cells[3][3]);
		Board board = new Board(cells);
		board.move(board.getCell(4, 4), board.getCell(2, 2));
	}
}