package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MagikAttackAction;
import ru.ulanov.rpg.action.MagikBuffAction;

/**
 * class ElfMage.
 */

public class HumanMage extends Mage {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public HumanMage(String name, String side) {
        super(name, side);
        getActionBehavior().add(new MagikAttackAction());
        getActionBehavior().add(new MagikBuffAction());
        setDamage(4);
        setNameType("Human Mage");
    }

    /**
     * metod make action.
     * @param target - target.
     * @param numberOfAction - action.
     * @return boolean.
     */
    public boolean takeAction(UserChar target, int numberOfAction) {
        if (this.isEmemy(target)) {
            return getActionBehavior().get(0).action(target, this.getDamage());
        }
        return getActionBehavior().get(1).action(target, this.getDamage());
    }
}
