package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.Action;
import java.util.ArrayList;

/**
 * class character.
 */

public abstract class UserChar {
    /** name.*/
    private String name;
    /** damage.*/
    private int damage;
    /** side.*/
    private String side;
    /** action behavior.*/
    private ArrayList<Action> actionBehavior = new ArrayList<>();
    /** health.*/
    private int hp;
    /** isAlave.*/
    private boolean isAlive;
    /** isBuffed.*/
    private boolean isBuffed;
    /** isDebuffed.*/
    private boolean isDebuffed;
    /** class name.*/
    private String nameType;

    /**
     * constructor.
     * @param name - name of character.
     * @param side - side.
     */
    public UserChar(String name, String side) {
        this.name = name;
        this.side = side;
        hp = 100;
        isAlive = true;
        isBuffed = false;
        isDebuffed = false;
        damage = 0;
    }

    /**
     * metod return actionbehavior.
     * @return action behavior.
     */
    ArrayList<Action> getActionBehavior() {
        return this.actionBehavior;
    }

    /**
     * metod take damage.
     * @param damage - damage.
     */
    public void takeDamage(int damage) {
        if (damage >= 0) {
            this.hp -= damage;
            if (this.hp <= 0) {
                isAlive = false;
            }
        }
    }

    /**
     * metod checks alive.
     * @return boolean.
     */
    public boolean checkAlive() {
        return isAlive;
    }

    /**
     * metod check buffed.
     * @return boolean.
     */
    public boolean checkBuff() {
        return isBuffed;
    }

    /**
     * metod set buff.
     */
    public void setBuff() {
        isBuffed = true;
    }

    /**
     * metod set debuff.
     */
    public void setDebuff() {
        this.isDebuffed = true;
    }

    /**
     * metod remove buff.
     */
    public void removeBuff() {
        this.isBuffed = false;
    }

    /**
     * metod checks enemy.
     * @param character - character.
     * @return boolean.
     */
    boolean isEmemy(UserChar character) {
        return !this.side.equals(character.side);
    }

    /**
     * medot setDamage.
     * @param damage - damage.
     * @return boolean.
     */
    public boolean setDamage(int damage) {
        if (damage >= 0) {
            this.damage = damage;
            return true;
        }
        return false;
    }

    /**
     * metod return damage.
     * @return - damage.
     */
    public int getDamage() {
        int currentDamage = this.damage;
        if (isBuffed) {
            currentDamage = (int) (this.damage * 1.5);
        }
        if (isDebuffed) {
            currentDamage = this.damage / 2;
        }
        return currentDamage;
    }

    /**
     * metod make action.
     * @param target - target.
     * @param numberOfAction - action.
     */
    public void makeAction(UserChar target, int numberOfAction) {
        System.out.print(this.toString());
        this.takeAction(target, numberOfAction);
        isDebuffed = false;
        isBuffed = false;
    }

    /**
     * metod take action.
     * @param target - target
     * @param numberOfAction - action.
     * @return boolean.
     */
    public abstract boolean takeAction(UserChar target, int numberOfAction);

    /**
     * metod to string.
     * @return string.
     */
    public String toString() {
        return String.format("%s %s", getNameType(), name);
    }

    /**
     * metod set name.
     * @param nameType - name type.
     */
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    /**
     * metod return name type.
     * @return name.
     */
    private String getNameType() {
        return nameType;
    }

    /**
     * metod return hp.
     * @return hp
     */
    public int getHp() {
        return hp;
    }
}
