package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MeleeAttack;
import ru.ulanov.rpg.action.RangeAttack;

/**
 * class ElfMage.
 */

public class ElfArcher extends RangeUnit {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public ElfArcher(String name, String side) {
        super(name, side);
        getActionBehavior().add(new RangeAttack());
        getActionBehavior().add(new MeleeAttack());
        setNameType("Elf Archer");
    }

    /**
     * metod make action.
     * @param target - target.
     * @param numberOfAction - action.
     * @return boolean.
     */
    public boolean takeAction(UserChar target, int numberOfAction) {
        if (numberOfAction == 0) {
            setDamage(7);
            return getActionBehavior().get(numberOfAction).action(target, this.getDamage());
        } else {
            setDamage(3);
            return getActionBehavior().get(numberOfAction).action(target, this.getDamage());
        }
    }
}
