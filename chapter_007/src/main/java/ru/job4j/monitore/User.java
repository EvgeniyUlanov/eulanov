package ru.job4j.monitore;

public class User {
    /** user id.*/
    private int id;
    /** amount.*/
    private int amount;

    /**
     * constructor.
     * @param id - id.
     * @param amount - amount.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * method getId.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * method getAmount.
     * @return amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * method takeValue.
     * @param value - value.
     * @return boolean.
     */
    public boolean takeValue(int value) {
        boolean result = false;
        if (value >= 0 && this.amount >= value) {
            this.amount -= value;
            result = true;
        }
        return result;
    }

    /**
     * method addValue.
     * @param value - value.
     * @return boolean.
     */
    public boolean addValue(int value) {
        boolean result = false;
        if (value >= 0) {
            this.amount += value;
            result = true;
        }
        return result;
    }

    /**
     * method toString.
     * @return string.
     */
    @Override
    public String toString() {
        return "user id = " + id + ", amount =  " + amount;
    }
}
