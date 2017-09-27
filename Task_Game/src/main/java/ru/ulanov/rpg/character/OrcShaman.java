package ru.ulanov.rpg.character;

import ru.ulanov.rpg.action.MagikBuffAction;
import ru.ulanov.rpg.action.MagikDamnationAction;

/**
 * class Orc shaman.
 */
public class OrcShaman extends Mage {

    /**
     * constructor.
     * @param name - name.
     * @param side - side.
     */
    public OrcShaman(String name, String side) {
        super(name, side);
        getActionBehavior().add(new MagikDamnationAction());
        getActionBehavior().add(new MagikBuffAction());
        setNameType("Orc Shaman");
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

