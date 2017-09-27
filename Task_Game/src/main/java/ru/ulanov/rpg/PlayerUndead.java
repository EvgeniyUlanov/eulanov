package ru.ulanov.rpg;

import ru.ulanov.rpg.character.UndeadArcher;
import ru.ulanov.rpg.character.UndeadFighter;
import ru.ulanov.rpg.character.UndeadNecromant;

/**
 * class Player undead.
 */
public class PlayerUndead extends Player {
    /**
     * constructor.
     * @param side - side.
     */
    public PlayerUndead(String side) {
        super(side);
        setRaceName("Undead");
        getHand().add(new UndeadNecromant("Nigosh", side));
        getHand().add(new UndeadArcher("Smael", side));
        getHand().add(new UndeadArcher("Bihal", side));
        getHand().add(new UndeadArcher("Dagot", side));
        getHand().add(new UndeadFighter("Vaast", side));
        getHand().add(new UndeadFighter("Demien", side));
        getHand().add(new UndeadFighter("Gosh", side));
        getHand().add(new UndeadFighter("Zitar", side));
    }
}

