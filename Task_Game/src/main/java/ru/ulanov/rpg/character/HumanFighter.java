package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MeleeAttack;

/**
 * class HumanFighter.
 */
public class HumanFighter extends Fighter {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public HumanFighter(String name, String side) {
        super(name, side);
        getActionBehavior().add(new MeleeAttack());
        setDamage(18);
        setNameType("Human Fighter");
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

