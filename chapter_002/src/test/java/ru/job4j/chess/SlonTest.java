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
		Board board = new Board();
		board.move(board.getCell(2, 0), board.getCell(0, 0));
	}

	/**
	 * test for right move.
	 */
	public void whenSlonMOvedRightDestThanFigureMoved() {
		Board board = new Board();
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
		Board board = new Board();
		board.move(board.getCell(0, 0), board.getCell(2, 0));
	}

	/**
	 * test for way is locked.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenWayIsOccupiedThanOccupiedWayException() {
		Board board = new Board();
		board.move(board.getCell(2, 0), board.getCell(4, 2));
	}
}