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

	/**
	 * constructor for class Board.
	 * @param cells - cells.
	 */
	public Board(Cell[][] cells) {
		this.cells = cells;
	}

	/**
	 * metod showBoard - shows board.
	 * @return String.
	 */
	public String showBoard() {
		System.out.println("");
		System.out.println("  0    1    2    3    4    5    6    7    x/y");
		System.out.println("+----+----+----+----+----+----+----+----+");
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			str.append("|    |    |    |    |    |    |    |    |\n");
			for (int j = 0; j < 8; j++) {
				str.append("| ");
				str.append(cells[j][i].show() + " ");
			}
			str.append("| - " + i + "\n");
			str.append("|    |    |    |    |    |    |    |    |\n");
			str.append("+----+----+----+----+----+----+----+----+\n");
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