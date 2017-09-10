package ru.job4j.chess;

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
		Figure king = new King(cells[2][1]);
		Board board = new Board(cells);
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
		Figure king = new King(cells[4][4]);
		Board board = new Board(cells);
		// King in target Cell.
		assertThat(board.getCell(4, 4).getFigure(), is(king));
		// King moving left.
		board.move(board.getCell(4, 4), board.getCell(3, 4));
		assertThat(board.getCell(3, 4).getFigure(), is(king));
		// King moving right.
		board.move(board.getCell(3, 4), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(king));
		// King moving down.
		board.move(board.getCell(4, 4), board.getCell(4, 5));
		assertThat(board.getCell(4, 5).getFigure(), is(king));
		// King moving up.
		board.move(board.getCell(4, 5), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(king));
		// King moving leftdown.
		board.move(board.getCell(4, 4), board.getCell(3, 5));
		assertThat(board.getCell(3, 5).getFigure(), is(king));
		// King moving rightup.
		board.move(board.getCell(3, 5), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(king));
		// King moving leftup.
		board.move(board.getCell(4, 4), board.getCell(3, 3));
		assertThat(board.getCell(3, 3).getFigure(), is(king));
		// King moving rightdown.
		board.move(board.getCell(3, 3), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(king));
	}

	/**
	 * test King can eat enemy figure.
	 */
	@Test
	public void whenKingEatEnemyFigureThanKingMovingToEnemyCell() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure king = new King(cells[4][4]);
		Figure pawn = new Pawn(cells[4][3], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		king.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 4), board.getCell(4, 3));
		assertThat(board.getCell(4, 3).getFigure(), is(king));
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
		Figure king = new King(cells[4][4]);
		Figure tura = new Tura(cells[4][3]);
		Board board = new Board(cells);
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
		Figure king = new King(cells[2][1]);
		Board board = new Board(cells);
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
		Figure king = new King(cells[2][1]);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(4, 3));
	}
}