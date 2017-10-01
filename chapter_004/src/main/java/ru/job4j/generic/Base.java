package ru.job4j.generic;

/**
 * abstract class Base.
 */
public abstract class Base {

    /** id.*/
    private String id;

    /**
     * metod getId.
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * metod set id.
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
