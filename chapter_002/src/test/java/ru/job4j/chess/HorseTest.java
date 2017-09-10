package ru.job4j.chess;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class HorseTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class HorseTest {

	/**
	 * test impossible move.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenHorseMovedWrongDestThanIvalideMoveExeption() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure horse = new Horse(cells[2][1]);
		Board board = new Board(cells);
		board.move(board.getCell(2, 1), board.getCell(3, 2));
	}

	/**
	 * test can move like horse.
	 */
	@Test
	public void whenHorseMovedInRightDirectionThanDirectionCellFullOfHorse() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure horse = new Horse(cells[4][4]);
		Board board = new Board(cells);
		// Horse in target Cell.
		assertThat(board.getCell(4, 4).getFigure(), is(horse));
		// Horse moving downleft.
		board.move(board.getCell(4, 4), board.getCell(3, 6));
		assertThat(board.getCell(3, 6).getFigure(), is(horse));
		// Horse moving upright.
		board.move(board.getCell(3, 6), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(horse));
		// Horse moving downright.
		board.move(board.getCell(4, 4), board.getCell(5, 6));
		assertThat(board.getCell(5, 6).getFigure(), is(horse));
		// Horse moving upleft.
		board.move(board.getCell(5, 6), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(horse));
		// Horse moving leftdown.
		board.move(board.getCell(4, 4), board.getCell(2, 5));
		assertThat(board.getCell(2, 5).getFigure(), is(horse));
		// Horse moving rightup.
		board.move(board.getCell(2, 5), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(horse));
		// Horse moving leftup.
		board.move(board.getCell(4, 4), board.getCell(2, 3));
		assertThat(board.getCell(2, 3).getFigure(), is(horse));
		// Horse moving rightdown.
		board.move(board.getCell(2, 3), board.getCell(4, 4));
		assertThat(board.getCell(4, 4).getFigure(), is(horse));
	}

	/**
	 * test Horse can eat enemy figure.
	 */
	@Test
	public void whenHorseEatEnemyFigureThanHorseMovingToEnemyCell() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure horse = new Horse(cells[4][4]);
		Figure pawn = new Pawn(cells[3][2], true);
		Board board = new Board(cells);
		Player white = new Player(1);
		Player black = new Player(2);
		horse.setPlayer(white);
		pawn.setPlayer(black);
		board.move(board.getCell(4, 4), board.getCell(3, 2));
		assertThat(board.getCell(3, 2).getFigure(), is(horse));
	}

	/**
	 * test can move throw another figure.
	 */
	@Test
	public void whenHorseMoveThrowAnotherFigureThanOk() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure horse = new Horse(cells[4][4]);
		Figure tura = new Tura(cells[2][5]);
		Figure tura2 = new Tura(cells[3][5]);
		Figure tura3 = new Tura(cells[4][5]);
		Figure tura4 = new Tura(cells[5][5]);
		Figure tura5 = new Tura(cells[6][5]);
		Board board = new Board(cells);
		board.move(board.getCell(4, 4), board.getCell(3, 6));
		assertThat(board.getCell(3, 6).getFigure(), is(horse));
	}
}