package ru.ulanov.rpg.action;

import ru.ulanov.rpg.character.UserChar;

/**
 * class melee attack.
 */
public class MeleeAttack implements Action {
    /**
     * metod action.
     * @param target - target.
     * @param damage - damage.
     * @return boolean.
     */
    public boolean action(UserChar target, int damage) {
        target.takeDamage(damage);
        System.out.println(String.format(" melee atack to %s with damage %s - %s health - %s",
                target.toString(), damage, target.toString(), target.getHp()));
        return true;
    }
}

