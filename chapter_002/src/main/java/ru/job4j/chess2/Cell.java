package ru.job4j.chess2;

/**
 * class Cell - is a piece of board.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */

public class Cell {
	/** coord x of cell.*/
	private int x;
	/** coord y of cell.*/
	private int y;

	/**
	 * constructor.
	 * @param x - coord x.
	 * @param y - coord y.
	 */
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * metod getX.
	 * @return x - coord x of cell.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * metod getY.
	 * @return y - coord y of cell.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * metod equalsCell - cheks that cell have the same coord.
	 * @param cell - cell.
	 * @return boolean.
	 */
	public boolean equalsCell(Cell cell) {
		if ((this.getX() == cell.getX()) && (this.getY() == cell.getY())) {
			return true;
		}
		return false;
	}
}