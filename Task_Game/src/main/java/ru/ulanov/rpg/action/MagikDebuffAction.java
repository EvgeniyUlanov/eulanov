package ru.ulanov.rpg.action;

import ru.ulanov.rpg.character.UserChar;

/**
 * class magik buff action.
 */
public class MagikDebuffAction implements Action {
    /**
     * metod action.
     * @param target - target.
     * @param damage - damage.
     * @return boolean.
     */
    public boolean action(UserChar target, int damage) {
        System.out.println(String.format(" set debuff to %s ", target.toString()));
        target.setDebuff();
        return true;
    }
}
