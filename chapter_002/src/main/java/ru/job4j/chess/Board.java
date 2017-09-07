package ru.job4j.chess;

/**
 * class Board.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Board {
	/** massive for keep cells. */
	private Cell[][] cells;
	/** massive for keep Figures. */
	private Figure[] figures;

	/**
	 * constructor for class Board.
	 * create massive of cells and figures.
	 */
	public Board() {

		this.cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		this.figures = new Figure[16];
		figures[0] = new Slon(cells[2][0]);
		figures[1] = new Slon(cells[5][0]);
		figures[2] = new Queen(cells[3][1]);
	}

	/**
	 * metod showBoard - shows board.
	 * @return String.
	 */
	public String showBoard() {
		System.out.println("");
		System.out.println("01234567  x/y");
		System.out.println("||||||||");
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				str.append(cells[j][i].show());
			}
			str.append(" - " + i + "\n");
		}
		return str.toString();
	}

	/**
	 * metod move - moves Figure if everything good.
	 * @param sourse - sourse Cell where figure is.
	 * @param dest - destanation of moving figure.
	 * @return boolean if move is correct.
	 */
	public boolean move(Cell sourse, Cell dest) {
		if (sourse.isEmpty()) {
			throw new FigureNotFoundException("Sourse Cell is empty");
		}
		if (!sourse.getFigure().clearPath(dest, this.cells)) {
			throw new OccupiedWayException("the way is Occupied");
		}
		sourse.getFigure().cloneTo(dest);
		sourse.cleanCell();
		return true;
	}

	/**
	 * metod getCell.
	 * @param x - x coord of cell.
	 * @param y - y coord od cell.
	 * @return cell from coord x,y.
	 */
	public Cell getCell(int x, int y) {
		return this.cells[x][y];
	}
}