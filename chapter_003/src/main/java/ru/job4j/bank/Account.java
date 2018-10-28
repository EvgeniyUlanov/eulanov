package ru.job4j.bank;

/**
 * class Account.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Account {
    /** value.*/
    private double value;
    /** requisites.*/
    private String requisites;
    /** isBelongToUser.*/
    private boolean isOccupied;

    /**
     * constructor.
     * @param requisites - requisites.
     */
    public Account(String requisites) {
        this.requisites = requisites;
        this.value = 0D;
        this.isOccupied = false;
    }

    /**
     * constructor.
     * @param requisites - requisites.
     * @param value - start value.
     */
    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
        this.isOccupied = false;
    }

    /**
     * method checkOccupied.
     * @return isOccupied.
     */
    public boolean checkOcupied() {
        return this.isOccupied;
    }

    /**
     * method setOccupied.
     */
    public void setOccupied() {
        this.isOccupied = true;
    }

    /**
     * method getValue.
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * method setValue.
     * @param value - value.
     * @return boolean.
     */
    public boolean addValue(double value) {
        if (value >= 0 && isOccupied) {
            this.value += value;
            return true;
        }
        return false;
    }

    /**
     * method takeValue.
     * @param value - value.
     * @return boolean.
     */
    public boolean takeValue(double value) {
        if (this.value >= value && value >= 0) {
            this.value -= value;
            return true;
        }
        return false;
    }

    /**
     * method getRequisites.
     * @return requisites.
     */
    public String getRequisites() {
        return requisites;
    }
}
