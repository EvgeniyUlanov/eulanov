package ru.ulanov.rpg.action;

import ru.ulanov.rpg.character.UserChar;

/**
 * class MagikAttackAction.
 */
public class MagikAttackAction implements Action {
    /**
     * metod action.
     * @param target - target.
     * @param damage - damage.
     * @return boolean.
     */
    public boolean action(UserChar target, int damage) {
        target.takeDamage(damage);
        System.out.println(String.format(" attack by magik to %s with damage %s - %s health - %s",
                target.toString(), damage, target.toString(), target.getHp()));
        return true;
    }
}
