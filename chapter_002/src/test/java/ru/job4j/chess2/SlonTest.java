package ru.job4j.chess2;

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
		Figure[] figures = {new Slon(cells[2][1])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(2, 1), board.getCell(2, 2));
	}

	/**
	 * test can move diagonal.
	 */
	@Test
	public void whenSlonMovedInRightDirectionThanDirectionCellReturnSlon() {
		Cell[][] cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		Figure[] figures = {new Slon(cells[4][4])};
		Board board = new Board(cells, figures);
		// slon moving leftdown.
		assertThat(board.move(cells[4][4], cells[2][6]), is(true));
		// slon moving rightup.
		assertThat(board.move(board.getCell(2, 6), board.getCell(4, 4)), is(true));
		// slon moving leftup.
		assertThat(board.move(board.getCell(4, 4), board.getCell(2, 2)), is(true));
		// slon moving rightdown.
		assertThat(board.move(board.getCell(2, 2), board.getCell(4, 4)), is(true));
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
		Figure[] figures = {new Slon(cells[4][4]), new Slon(cells[3][3])};
		Board board = new Board(cells, figures);
		board.move(board.getCell(4, 4), board.getCell(2, 2));
	}
}