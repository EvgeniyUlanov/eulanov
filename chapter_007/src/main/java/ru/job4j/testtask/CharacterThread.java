package ru.job4j.testtask;

abstract class CharacterThread implements Runnable {
    /** boolean isStop.*/
    private boolean isStop;
    /** board.*/
    private Character character;

    /**
     * constructor.
     * @param character - board.
     */
    CharacterThread(Character character) {
        this.character = character;
    }

    void setStop() {
        this.isStop = true;
    }

    boolean getStop() {
        return isStop;
    }

    Character getCharacter() {
        return character;
    }
}
