package ru.ulanov.rpg;

import ru.ulanov.rpg.character.OrcArcher;
import ru.ulanov.rpg.character.OrcFighter;
import ru.ulanov.rpg.character.OrcShaman;

/**
 * class player orc.
 */
public class PlayerOrc extends Player {
    /**
     * constructor.
     * @param side - side.
     */
    public PlayerOrc(String side) {
        super(side);
        setRaceName("Orc");
        getHand().add(new OrcShaman("Ugluk", side));
        getHand().add(new OrcArcher("Gorback", side));
        getHand().add(new OrcArcher("Shagrat", side));
        getHand().add(new OrcArcher("Urthang", side));
        getHand().add(new OrcFighter("Pitloh", side));
        getHand().add(new OrcFighter("Turog", side));
        getHand().add(new OrcFighter("Mihur", side));
        getHand().add(new OrcFighter("Urveg", side));
    }
}

