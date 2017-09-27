package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MeleeAttack;

/**
 * class Undead fighter.
 */
public class UndeadFighter extends Fighter {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public UndeadFighter(String name, String side) {
        super(name, side);
        getActionBehavior().add(new MeleeAttack());
        setDamage(18);
        setNameType("Zombi");
    }

    /**
     * metod make action.
     * @param target - target.
     * @param numberOfAction - action.
     * @return boolean.
     */
    public boolean takeAction(UserChar target, int numberOfAction) {
        return getActionBehavior().get(0).action(target, this.getDamage());
    }
}

