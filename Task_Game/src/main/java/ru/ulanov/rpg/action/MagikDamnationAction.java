package ru.ulanov.rpg.action;
import ru.ulanov.rpg.character.UserChar;

/**
 * class magik buff action.
 */
public class MagikDamnationAction implements Action {
    /**
     * metod action.
     * @param target - target.
     * @param damage - damage.
     * @return boolean.
     */
    public boolean action(UserChar target, int damage) {
        System.out.println(String.format(" set damnation to %s ", target.toString()));
        target.removeBuff();
        return true;
    }
}

