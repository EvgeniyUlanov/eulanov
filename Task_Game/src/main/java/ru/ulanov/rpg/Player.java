package ru.ulanov.rpg;

import ru.ulanov.rpg.character.UserChar;
import java.util.ArrayList;

/**
 * class player.
 */
public abstract class Player {
    /** hand.*/
    private ArrayList<UserChar> hand = new ArrayList<>();
    /** raceName.*/
    private String raceName;
    /** side.*/
    private String side;
    /** buffed units.*/
    private ArrayList<UserChar> buffedUnits = new ArrayList<>();
    /** ordinary units.*/
    private ArrayList<UserChar> ordinaryUnits = new ArrayList<>();

    /**
     * constructor.
     * @param side - side.
     */
    public Player(String side) {
        this.side = side;
    }

    /**
     *  metod sets race name.
     * @param raceName - race name.
     */
    void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    /**
     * metod returns race name.
     * @return racename.
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * metod returns hand.
     * @return hand.
     */
    public ArrayList<UserChar> getHand() {
        return hand;
    }

    /**
     * buffed units.
     * @return bufed.
     */
    public ArrayList<UserChar> getBuffedUnits() {
        return buffedUnits;
    }

    /**
     * ordinary units.
     * @return ordinary.
     */
    public ArrayList<UserChar> getOrdinaryUnits() {
        return ordinaryUnits;
    }
}
