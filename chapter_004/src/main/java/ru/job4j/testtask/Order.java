package ru.job4j.testtask;

/**
 * class Order.
 */
public class Order {

    /** order id.*/
    private int orderId;
    /** operation.*/
    private String operation;
    /** price.*/
    private Double price;
    /** volume.*/
    private Integer volume;

    /**
     * constructor.
     * @param orderId - order id.
     * @param operation - operation type.
     * @param price - price.
     * @param volume - volume.
     */
    public Order(int orderId, String operation, Double price, Integer volume) {
        this.orderId = orderId;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
    }

    /**
     * method getOrderId.
     * @return order id.
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * method getOperation.
     * @return operation.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * method getPrice.
     * @return price.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * method getVolume.
     * @return volume.
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * method setVolume.
     * @param newVolume new volume.
     */
    public void setVolume(Integer newVolume) {
        this.volume = newVolume;
    }

    /**
     * method equals.
     * @param o - object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (o == this) {
            result = true;
        } else if (o instanceof Order) {
            result = ((Order) o).orderId == this.orderId;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * method hashCode.
     * @return int.
     */
    @Override
    public int hashCode() {
        return orderId;
    }

    @Override
    public String toString() {
        return orderId + " " + operation + " " + price + "@" + volume;
    }
}