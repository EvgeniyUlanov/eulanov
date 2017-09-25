package ru.ulanov.rpg;

import ru.ulanov.rpg.character.HumanArcher;
import ru.ulanov.rpg.character.HumanFighter;
import ru.ulanov.rpg.character.HumanMage;

/**
 * class player human.
 */
public class PlayerHuman extends Player {
    /**
     * constructor.
     * @param side - side.
     */
    public PlayerHuman(String side) {
        super(side);
        setRaceName("Human");
        getHand().add(new HumanMage("Nikolay", side));
        getHand().add(new HumanArcher("Sergey", side));
        getHand().add(new HumanArcher("Ilia", side));
        getHand().add(new HumanArcher("Ivan", side));
        getHand().add(new HumanFighter("Oleg", side));
        getHand().add(new HumanFighter("Vladimir", side));
        getHand().add(new HumanFighter("Yaroslav", side));
        getHand().add(new HumanFighter("Aleksandr", side));
    }
}
