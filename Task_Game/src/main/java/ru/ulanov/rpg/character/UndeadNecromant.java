package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MagikAttackAction;
import ru.ulanov.rpg.action.MagikDebuffAction;

/**
 * class Necromant.
 */
public class UndeadNecromant extends Mage {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public UndeadNecromant(String name, String side) {
        super(name, side);
        getActionBehavior().add(new MagikDebuffAction());
        getActionBehavior().add(new MagikAttackAction());
        setDamage(5);
        setNameType("Undead Necromant");
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
