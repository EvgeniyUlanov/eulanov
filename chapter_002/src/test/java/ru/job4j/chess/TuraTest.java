package ru.job4j.chess;

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
		Figure tura = new Tura(cells[2][1]);
		Board board = new Board(cells);
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
		Figure tura = new Tura(cells[2][1]);
		Board board = new Board(cells);
		// Tura in target Cell.
		assertThat(board.getCell(2, 1).getFigure(), is(tura));
		// Tura moving down.
		board.move(board.getCell(2, 1), board.getCell(2, 3));
		assertThat(board.getCell(2, 3).getFigure(), is(tura));
		// Tura moving up.
		board.move(board.getCell(2, 3), board.getCell(2, 1));
		assertThat(board.getCell(2, 1).getFigure(), is(tura));
		// Tura moving right.
		board.move(board.getCell(2, 1), board.getCell(7, 1));
		assertThat(board.getCell(7, 1).getFigure(), is(tura));
		// Tura moving left.
		board.move(board.getCell(7, 1), board.getCell(0, 1));
		assertThat(board.getCell(0, 1).getFigure(), is(tura));
	}

	/**
	 * test Tura can eat enemy figure.
	 */
	@Test
	public void whenTuraEatEnemyFigureThanTuraChangeCellToEnemyCell() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure tura = new Tura(cells[4][0]);
		Figure pawn = new Pawn(cells[4][5], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		tura.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 0), board.getCell(4, 5));
		assertThat(board.getCell(4, 5).getFigure(), is(tura));
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
		Figure tura = new Tura(cells[4][0]);
		Figure pawn = new Pawn(cells[4][5], true);
		Board board = new Board(cells);
		board.move(board.getCell(4, 0), board.getCell(4, 7));
	}
}