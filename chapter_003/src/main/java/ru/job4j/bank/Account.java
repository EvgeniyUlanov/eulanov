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
     * metod checkOccupied.
     * @return isOccupied.
     */
    public boolean checkOcupied() {
        return this.isOccupied;
    }

    /**
     * metod setOccupied.
     */
    public void setOccupied() {
        this.isOccupied = true;
    }

    /**
     * metod getValue.
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * metod setValue.
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
     * metod takeValue.
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
     * metod getRequisites.
     * @return requiseites.
     */
    public String getRequisites() {
        return requisites;
    }
}
