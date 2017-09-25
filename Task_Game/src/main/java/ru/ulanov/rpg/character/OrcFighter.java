package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MeleeAttack;

/**
 * class Orc fighter.
 */
public class OrcFighter extends Fighter {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public OrcFighter(String name, String side) {
        super(name, side);
        getActionBehavior().add(new MeleeAttack());
        setDamage(20);
        setNameType("Goblin");
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
