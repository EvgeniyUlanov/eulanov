package ru.ulanov.rpg.action;

import ru.ulanov.rpg.character.UserChar;

/**
 * interface Action.
 */

public interface Action {
    /**
     * metod action.
     * @param target - target.
     * @param damage - damage.
     * @return boolean.
     */
    boolean action(UserChar target, int damage);
}
