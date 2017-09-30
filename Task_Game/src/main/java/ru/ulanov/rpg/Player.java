package ru.ulanov.rpg;

import ru.ulanov.rpg.character.Fighter;
import ru.ulanov.rpg.character.Mage;
import ru.ulanov.rpg.character.RangeUnit;
import ru.ulanov.rpg.character.UserChar;
import java.util.ArrayList;
import java.util.Random;

/**
 * class player.
 */
public abstract class Player {
    /** hand.*/
    private ArrayList<UserChar> hand = new ArrayList<>();
    /** raceName.*/
    private String raceName;
    /** side.*/
    private String side;
    /** activeUnits.*/
    private ArrayList<UserChar> activeUnits = new ArrayList<>();
    /** random.*/
    private Random rn = new Random();

    /**
     * constructor.
     * @param side - side.
     */
    public Player(String side) {
        this.side = side;
    }

    /**
     *  metod sets race name.
     * @param raceName - race name.
     */
    void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    /**
     * metod returns race name.
     * @return racename.
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * metod returns hand.
     * @return hand.
     */
    public ArrayList<UserChar> getHand() {
        return hand;
    }

    public void makeMove(Player enemy) {
        if (this.getHand().size() > 0 && enemy.getHand().size() > 0) {
            UserChar activeChar = chooseActiveChar();
            UserChar target;
            if (activeChar instanceof Mage) {
                target = mageMove(activeChar, enemy);
            } else if (activeChar instanceof RangeUnit) {
                target = rangeUnitMove(activeChar, enemy);
            } else {
                target = figtherMove(activeChar, enemy);
            }
            this.activeUnits.remove(activeChar);
            if (!target.checkAlive()) {
                System.out.println(String.format("%s was killed", target.toString()));
            }
            this.deleteDeadUnits();
            enemy.deleteDeadUnits();
        }
    }

    /**
     * metod choose active char.
     * @return char.
     */
    private UserChar chooseActiveChar() {
        for (UserChar unit : this.activeUnits) {
            if (unit.checkBuff()) {
                return unit;
            }
        }
        return activeUnits.get(rn.nextInt(activeUnits.size()));
    }

    /**
     * metod deletes dead unit from player.
     */
    private void deleteDeadUnits() {
        if (this.getHand().size() > 0) {
            ArrayList<UserChar> unitToDelete = new ArrayList<>();
            for (UserChar unit : this.getHand()) {
                if (unit.getHp() <= 0) {
                    unitToDelete.add(unit);
                }
            }
            this.getHand().removeAll(unitToDelete);
            this.activeUnits.removeAll(unitToDelete);
        }
    }

    /**
     * metod set active units.
     */
    public void fillActiveUnits() {
        activeUnits.clear();
        for (UserChar unit : this.hand) {
            if (unit.checkAlive()) {
                activeUnits.add(unit);
            }
        }
    }

    /**
     * metod checks that player can move.
     * @return boolean.
     */
    public boolean canMove() {
        return this.activeUnits.size() > 0 && this.hand.size() > 0;
    }

    /**
     * metod mage move.
     * @param mage - unit.
     * @param enemy - enemy.
     * @return target.
     */
    private UserChar mageMove(UserChar mage, Player enemy) {
        UserChar target;
        int numberOfAction = rn.nextInt(2);
        if (numberOfAction == 0) {
            target = enemy.getHand().get(rn.nextInt(enemy.getHand().size()));
        } else {
            target = this.getHand().get(rn.nextInt(this.getHand().size()));
        }
        mage.makeAction(target, numberOfAction);
        return target;
    }

    /**
     * metod rangeUnit move.
     * @param rangeUnit - unit
     * @param enemy - enemy.
     * @return target.
     */
    private UserChar rangeUnitMove(UserChar rangeUnit, Player enemy) {
        UserChar target;
        int numberOfAction;
        boolean canRangeAttack = false;
        for (UserChar unit : this.getHand()) {
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
        rangeUnit.makeAction(target, numberOfAction);
        return target;
    }
    private UserChar figtherMove(UserChar fighter, Player enemy) {
        UserChar target;
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
        fighter.makeAction(target, 0);
        return target;
    }
}

