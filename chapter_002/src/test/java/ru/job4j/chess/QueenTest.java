package ru.job4j.chess;

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
		Figure queen = new Queen(cells[2][1]);
		Board board = new Board(cells);
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
		Figure queen = new Queen(cells[4][4]);
		Board board = new Board(cells);
		// Queen in target Cell.
		assertThat(board.getCell(4, 4).getFigure(), is(queen));
		// Queen moving left.
		board.move(board.getCell(4, 4), board.getCell(1, 4));
		assertThat(board.getCell(1, 4).getFigure(), is(queen));
		// Queen moving right.
		board.move(board.getCell(1, 4), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(queen));
		// Queen moving down.
		board.move(board.getCell(4, 4), board.getCell(4, 7));
		assertThat(board.getCell(4, 7).getFigure(), is(queen));
		// Queen moving up.
		board.move(board.getCell(4, 7), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(queen));
		// Queen moving leftdown.
		board.move(board.getCell(4, 4), board.getCell(2, 6));
		assertThat(board.getCell(2, 6).getFigure(), is(queen));
		// Queen moving rightup.
		board.move(board.getCell(2, 6), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(queen));
		// Queen moving leftup.
		board.move(board.getCell(4, 4), board.getCell(2, 2));
		assertThat(board.getCell(2, 2).getFigure(), is(queen));
		// Queen moving rightdown.
		board.move(board.getCell(2, 2), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(queen));
	}

	/**
	 * test Queen can eat enemy figure.
	 */
	@Test
	public void whenQueenEatEnemyFigureThanQueenMovingToEnemyCell() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure queen = new Queen(cells[4][4]);
		Figure pawn = new Pawn(cells[0][4], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		queen.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 4), board.getCell(0, 4));
		assertThat(board.getCell(0, 4).getFigure(), is(queen));
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
		Figure queen = new Queen(cells[4][4]);
		Figure tura = new Tura(cells[1][4]);
		Board board = new Board(cells);
		board.move(board.getCell(4, 4), board.getCell(0, 4));
	}
}