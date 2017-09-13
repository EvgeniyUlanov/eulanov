package ru.job4j.chess2;

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
	 * constructor.
	 * @param cells - cells.
	 * @param figures - figures.
	 */
	public Board(Cell[][] cells, Figure[] figures) {
		this.cells = cells;
		this.figures = figures;
	}

	/**
	 * metod move - moves Figure if everything good.
	 * @param sourse - sourse Cell where figure is.
	 * @param dest - destanation of moving figure.
	 * @return boolean if move is correct.
	 */
	public boolean move(Cell sourse, Cell dest) {
		Figure figureToMove = null;
		for (Figure figure : this.figures) {
			if (figure.getPosition().equals(sourse)) {
				figureToMove = figure;
				break;
			}
		}
		if (figureToMove == null) {
			throw new FigureNotFoundException("Figure not found");
		}
		boolean bool = figureToMove.clearPath(dest, this.figures);
		if (!bool) {
			throw new OccupiedWayException("the way is Occupied");
		}
		figureToMove.cloneTo(dest);
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