package ru.job4j.chess2;

import org.junit.Test;
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
		Figure[] figures = {new Horse(cells[2][1])};
		Board board = new Board(cells, figures);
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
		Figure[] figures = {new Horse(cells[4][4])};
		Board board = new Board(cells, figures);
		// Horse moving downleft.
		board.move(board.getCell(4, 4), board.getCell(3, 6));
		assertThat(figures[0].getPosition(), is(cells[3][6]));
		// Horse moving upright.
		board.move(board.getCell(3, 6), board.getCell(4, 4));
		assertThat(figures[0].getPosition(), is(cells[4][4]));
		// Horse moving downright.
		board.move(board.getCell(4, 4), board.getCell(5, 6));
		assertThat(figures[0].getPosition(), is(cells[5][6]));
		// Horse moving upleft.
		board.move(board.getCell(5, 6), board.getCell(4, 4));
		assertThat(figures[0].getPosition(), is(cells[4][4]));
		// Horse moving leftdown.
		board.move(board.getCell(4, 4), board.getCell(2, 5));
		assertThat(figures[0].getPosition(), is(cells[2][5]));
		// Horse moving rightup.
		board.move(board.getCell(2, 5), board.getCell(4, 4));
		assertThat(figures[0].getPosition(), is(cells[4][4]));
		// Horse moving leftup.
		board.move(board.getCell(4, 4), board.getCell(2, 3));
		assertThat(figures[0].getPosition(), is(cells[2][3]));
		// Horse moving rightdown.
		board.move(board.getCell(2, 3), board.getCell(4, 4));
		assertThat(figures[0].getPosition(), is(cells[4][4]));
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
		Figure[] figures = {new Horse(cells[4][4]),
							new Tura(cells[2][5]),
							new Tura(cells[3][5]),
							new Tura(cells[4][5]),
							new Tura(cells[5][5]),
							new Tura(cells[6][5])};
		Board board = new Board(cells, figures);
		assertThat(board.move(cells[4][4], board.getCell(3, 6)), is(true));
	}
}