package ru.job4j.chess2;

/**
 * class Pawn - extends Figure.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Pawn extends Figure {
	/** count of moves.*/
	private int count;
	/** moving up.*/
	private boolean movingUp;

	/**
	 * constructor.
	 * @param start - cell were figure set.
	 * @param movingUp - boolean.
	 */
	public Pawn(Cell start, boolean movingUp) {
		super(start);
		this.movingUp = movingUp;
	}

	/**
	 * metod valideMove - checks correct move.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean valideMove(Cell dest) {
		if (!movingUp) {
			return moveDown(dest);
		} else {
			return moveUp(dest);
		}
	}

	/**
	 * metod moveUp.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean moveUp(Cell dest) {
		if (count == 0) {
			if (dest.getX() == this.getPosition().getX()
				    && this.getPosition().getY() - dest.getY() <= 2) {
				this.setMoveBehavior(new MoveStraight(this.getPosition()));
				count++;
				return true;
			}
		} else {
			if (dest.getX() == this.getPosition().getX()
				    && this.getPosition().getY() - dest.getY() == 1) {
				this.setMoveBehavior(new MoveStraight(this.getPosition()));
				return true;
			}
		}
		return false;
	}

	/**
	 * metod moveDown.
	 * @param dest - destanation cell.
	 * @return boolean.
	 */
	public boolean moveDown(Cell dest) {
		if (count == 0) {
			if (dest.getX() == this.getPosition().getX()
				    && dest.getY() - this.getPosition().getY() <= 2) {
				this.setMoveBehavior(new MoveStraight(this.getPosition()));
				count++;
				return true;
			}
		} else {
			if (dest.getX() == this.getPosition().getX()
				    && dest.getY() - this.getPosition().getY() == 1) {
				this.setMoveBehavior(new MoveStraight(this.getPosition()));
				return true;
			}
		}
		return false;
	}
}