package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class CellTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

 public class CellTest {

	/**
	 * test for metod isEmpty.
	 */
	@Test
	public void whenCellCreateCellIsEmpty() {
		Cell cell = new Cell(0, 0);
		assertThat(cell.isEmpty(), is(true));
	}

	/**
	 * test for metod setFigure, getFigure, cleanCell.
	 */
	@Test
	public void whenFigureSetInCellTheCellConteinFigure() {
		Cell cell = new Cell(0, 0);
		Figure figure = new Slon(cell);
		assertThat(cell.getFigure(), is(figure));
		cell.cleanCell();
		assertThat(cell.isEmpty(), is(true));
	}
}