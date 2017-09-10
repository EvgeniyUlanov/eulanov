package ru.job4j.chess;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class PawnTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class PawnTest {

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
		Figure pawn = new Pawn(cells[2][1], false);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(3, 2));
	}

	/**
	 * test first move can be 2 cells.
	 */
	@Test
	public void whenPawnMovedTwoCellsThanTrue() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure pawn = new Pawn(cells[2][1], false);
		Board board = new Board(cells);
		assertThat(board.getCell(2, 1).getFigure(), is(pawn));
		board.move(board.getCell(2, 1), board.getCell(2, 3));
		assertThat(board.getCell(2, 3).getFigure(), is(pawn));
	}

	/**
	 * test next pawn's move can be only 1 cell.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenPawnSecondMoveIsTwoCellThanImpossibleMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure pawn = new Pawn(cells[2][1], false);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(2, 3));
		board.move(board.getCell(2, 3), board.getCell(2, 5));
	}

	/**
	 * test that pawn cannot move back.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenPawnMovedBackThanImpossibleMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure pawn = new Pawn(cells[2][1], false);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(2, 3));
		board.move(board.getCell(2, 3), board.getCell(2, 1));
	}

	/**
	 * test that pawn can eat another figure diagonal.
	 */
	@Test
	public void whenPawnEatAnotherFigureDiagonalThanTrue() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure pawn = new Pawn(cells[4][4], false);
		Figure pawn2 = new Pawn(cells[5][5], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		pawn.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 4), board.getCell(5, 5));
		assertThat(board.getCell(5, 5).getFigure(), is(pawn));
	}

	/**
	 * test that pawn cannot eat another figure straigth.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenPawnEatAnotherFigureStraightThanImpossibleMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure pawn = new Pawn(cells[4][4], false);
		Figure pawn2 = new Pawn(cells[4][5], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		pawn.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 4), board.getCell(4, 5));
	}
}