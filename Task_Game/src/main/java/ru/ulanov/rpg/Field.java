package ru.ulanov.rpg;

import ru.ulanov.rpg.character.Fighter;
import ru.ulanov.rpg.character.Mage;
import ru.ulanov.rpg.character.RangeUnit;
import ru.ulanov.rpg.character.UserChar;
import java.util.ArrayList;
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
		beforeTurn();
		System.out.println(firstPlayer.getBuffedUnits());
		System.out.println(firstPlayer.getOrdinaryUnits());
		System.out.println(secondPlayer.getBuffedUnits());
		System.out.println(secondPlayer.getOrdinaryUnits());
		do {
			if (playerMove.getBuffedUnits().size() > 0 || playerMove.getOrdinaryUnits().size() > 0) {
				playerMakeMove();
			}
			deleteDeadUnits(firstPlayer);
			deleteDeadUnits(secondPlayer);
			changePlayer();
		} while (!checkEndOfTurn());
	}

	/**
	 * metod before turn.
	 */
	private void beforeTurn() {
		firstPlayer.getOrdinaryUnits().clear();
		firstPlayer.getBuffedUnits().clear();
		secondPlayer.getOrdinaryUnits().clear();
		secondPlayer.getBuffedUnits().clear();
		// Create first player buffed list.
		for (UserChar playerUnit : firstPlayer.getHand()) {
			if (playerUnit.checkBuff()) {
				firstPlayer.getBuffedUnits().add(playerUnit);
			}
		}
		// Create second player buffed list.
		for (UserChar playerUnit : secondPlayer.getHand()) {
			if (playerUnit.checkBuff()) {
				secondPlayer.getBuffedUnits().add(playerUnit);
			}
		}
		// Create first player list of ordinary units.
		firstPlayer.getOrdinaryUnits().addAll(firstPlayer.getHand());
		firstPlayer.getOrdinaryUnits().removeAll(firstPlayer.getBuffedUnits());

		// Create second player list of ordinary units.
		secondPlayer.getOrdinaryUnits().addAll(secondPlayer.getHand());
		secondPlayer.getOrdinaryUnits().removeAll(secondPlayer.getBuffedUnits());
		firstMove();
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
	private boolean checkEndOfTurn() {
		return (firstPlayer.getBuffedUnits().size() == 0 && firstPlayer.getOrdinaryUnits().size() == 0)
				&& (secondPlayer.getBuffedUnits().size() == 0 && secondPlayer.getOrdinaryUnits().size() == 0)
				|| firstPlayer.getHand().size() == 0 || secondPlayer.getHand().size() == 0;
	}

	/**
	 * metod move.
	 */
	private void playerMakeMove() {
		if (playerMove.getHand().size() > 0
				&& enemy.getHand().size() > 0) {
			UserChar activeChar = chooseActiveChar();
			UserChar target;
			int numberOfAction = 0;
			if (activeChar instanceof Mage) {
				numberOfAction = rn.nextInt(2);
				if (numberOfAction == 0) {
					target = enemy.getHand().get(rn.nextInt(enemy.getHand().size()));
				} else {
					target = playerMove.getHand().get(rn.nextInt(playerMove.getHand().size()));
				}
			} else if (activeChar instanceof RangeUnit) {
				boolean canRangeAttack = false;
				for (UserChar unit : playerMove.getHand()) {
					if (unit instanceof Fighter) {
						canRangeAttack = true;
						break;
					}
				}
				if (canRangeAttack) {
					numberOfAction = 0;
				} else {
					numberOfAction = 1;
				}
				target = enemy.getHand().get(rn.nextInt(enemy.getHand().size()));
			} else {
				ArrayList<UserChar> enemyFighters = new ArrayList<>();
				for (UserChar unit : enemy.getHand()) {
					if (unit instanceof Fighter) {
						enemyFighters.add(unit);
					}
				}
				if (enemyFighters.size() > 0) {
					target = enemyFighters.get(rn.nextInt(enemyFighters.size()));
				} else {
					target = enemy.getHand().get(rn.nextInt(enemy.getHand().size()));
				}
			}
			activeChar.makeAction(target, numberOfAction);
			if (!target.checkAlive()) {
				System.out.println(String.format("%s was killed", target.toString()));
				enemy.getHand().remove(target);
				enemy.getBuffedUnits().remove(target);
				enemy.getOrdinaryUnits().remove(target);
			}
		}
	}

	/**
	 * metod deletes dead unit from player.
	 * @param player - player.
	 */
	private void deleteDeadUnits(Player player) {
		if (player.getHand().size() > 0) {
			ArrayList<UserChar> unitToDelete = new ArrayList<>();
			for (UserChar unit : player.getHand()) {
				if (unit.getHp() < 0) {
					unitToDelete.add(unit);
				}
			}
			player.getHand().removeAll(unitToDelete);
		}
	}

	/**
	 * metod choose active char.
	 * @return char.
	 */
	private UserChar chooseActiveChar() {
		UserChar result = null;
		if (playerMove.getBuffedUnits().size() > 0) {
			result = playerMove.getBuffedUnits().get(rn.nextInt(playerMove.getBuffedUnits().size()));
			playerMove.getBuffedUnits().remove(result);
		} else if (playerMove.getOrdinaryUnits().size() > 0) {
			result = playerMove.getOrdinaryUnits().get(rn.nextInt(playerMove.getOrdinaryUnits().size()));
			playerMove.getOrdinaryUnits().remove(result);
		}
		return result;
	}
}