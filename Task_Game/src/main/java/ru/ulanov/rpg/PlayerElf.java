package ru.ulanov.rpg;

import ru.ulanov.rpg.character.ElfArcher;
import ru.ulanov.rpg.character.ElfFighter;
import ru.ulanov.rpg.character.ElfMage;

/**
 * class Player elf.
 */
public class PlayerElf extends Player {
    /**
     * constructor.
     * @param side - side.
     */
    public PlayerElf(String side) {
        super(side);
        setRaceName("Elf");
        getHand().add(new ElfMage("Sirael", side));
        getHand().add(new ElfArcher("Tiron", side));
        getHand().add(new ElfArcher("Irime", side));
        getHand().add(new ElfArcher("Veon", side));
        getHand().add(new ElfFighter("Tauriel", side));
        getHand().add(new ElfFighter("Anarendil", side));
        getHand().add(new ElfFighter("Elenandar", side));
        getHand().add(new ElfFighter("Inon", side));
    }
}
