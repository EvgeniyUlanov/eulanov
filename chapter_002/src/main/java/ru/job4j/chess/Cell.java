package ru.job4j.chess;

/**
 * class Cell - is a piece of board.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */

public class Cell {
	/** boolean empty. */
	private boolean empty;
	/** figure that cell contein.*/
	private Figure figure;
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
		this.empty = true;
		this.x = x;
		this.y = y;
	}

	/**
	 * metod isEmpty.
	 * @return boolean - if cell is empty return true.
	 */
	public boolean isEmpty() {
		return this.empty;
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
	 * metod setFigure - set figure to cell.
	 * @param figure - figure to set.
	 */
	public void setFigure(Figure figure) {
		this.empty = false;
		this.figure = figure;
	}

	/**
	 * metod getFigure - return figure that cell conteins.
	 * @return figure.
	 */
	public Figure getFigure() {
		return this.figure;
	}

	/**
	 * metod cleanCell.
	 */
	public void cleanCell() {
		this.empty = true;
		this.figure = null;
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

	/**
	 * metod show - shows simbol.
	 * @return String - if empty return 0, if not empty return simbol of figure.
	 */
	public String show() {
		if (this.empty) {
			return "0";
		} else {
			return this.figure.show();
		}
	}
}