package ru.ulanov.rpg.action;

import ru.ulanov.rpg.character.UserChar;

/**
 * class magik buff action.
 */
public class MagikBuffAction implements Action {
    /**
     * metod action.
     * @param target - target.
     * @param damage - damage.
     * @return boolean.
     */
    public boolean action(UserChar target, int damage) {
        System.out.println(String.format(" set buff to %s ", target.toString()));
        target.setBuff();
        return true;
    }
}