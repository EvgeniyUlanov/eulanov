package ru.ulanov.rpg;

import java.util.Random;

/**
 * class Field .
 */

class Field {
	/** first player.*/
	private Player firstPlayer;
	/** second player.*/
	private Player secondPlayer;
	/** random.*/
	private Random rn = new Random();
	/** player move.*/
	private Player playerMove;
	/** player enemy.*/
	private Player enemy;

	/**
	 * constructor.
	 * @param first - first player.
	 * @param second - second player.
	 */
	Field(Player first, Player second) {
		this.firstPlayer = first;
		this.secondPlayer = second;
	}

	/**
	 * metod nextTurn.
	 */
	void nextTurn() {
		firstPlayer.fillActiveUnits();
		secondPlayer.fillActiveUnits();
		firstMove();
		while (notEndOfTurn()) {
			if (playerMove.canMove()) {
				playerMove.makeMove(enemy);
			}
			changePlayer();
		}
	}

	/**
	 * metod choose player for first move.
	 */
	private void firstMove() {
		if (rn.nextInt(2) == 0) {
			playerMove = firstPlayer;
			enemy = secondPlayer;
		}
		playerMove = secondPlayer;
		enemy = firstPlayer;
	}

	/**
	 * metod change player move.
	 */
	private void changePlayer() {
		playerMove = playerMove == firstPlayer ? secondPlayer : firstPlayer;
		enemy = enemy == firstPlayer ? secondPlayer : firstPlayer;
	}

	/**
	 * metod checks end of turn.
	 * @return boolean.
	 */
	private boolean notEndOfTurn() {
		return (firstPlayer.canMove() || secondPlayer.canMove())
				&& firstPlayer.getHand().size() > 0 && secondPlayer.getHand().size() > 0;
	}
}
