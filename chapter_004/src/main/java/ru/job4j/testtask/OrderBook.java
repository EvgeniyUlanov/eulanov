package ru.job4j.testtask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;

/**
 * class OrderBook.
 */
public class OrderBook {

    /** orderbook name.*/
    private String orderBookName;
    /** comparator.*/
    private Comparator<Double> highPrice = new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o2.compareTo(o1);
        }
    };
    /** tree map for keep ask orders.*/
    private TreeMap<Double, LinkedList<Order>> askOrders = new TreeMap<>();
    /** tree map for keep bid orders.*/
    private TreeMap<Double, LinkedList<Order>> bidOrders = new TreeMap<>(highPrice);

    /**
     * constructor.
     * @param orderBookName - book name.
     */
    public OrderBook(String orderBookName) {
        this.orderBookName = orderBookName;
    }

    /**
     * method add.
     * @param orderToAdd - order.
     */
    public void add(Order orderToAdd) {
        Double price = orderToAdd.getPrice();
        if (orderToAdd.getOperation().equals("SELL")) {
            if (adjustSell(orderToAdd) != null) {
                if (askOrders.containsKey(price)) {
                    askOrders.get(price).add(orderToAdd);
                } else {
                    askOrders.put(price, new LinkedList<>(Arrays.asList(orderToAdd)));
                }
            }
        } else if (orderToAdd.getOperation().equals("BUY")) {
            if (adjustBuy(orderToAdd) != null) {
                if (bidOrders.containsKey(price)) {
                    bidOrders.get(price).add(orderToAdd);
                } else {
                    bidOrders.put(price, new LinkedList<>(Arrays.asList(orderToAdd)));
                }
            }
        }
    }

    /**
     * method delete.
     * @param orderId - id.
     */
    public void delete(int orderId) {
        if (!deleteFromMap(askOrders, orderId)) {
            deleteFromMap(bidOrders, orderId);
        }
    }

    /**
     * method delete.
     * @param map - map.
     * @param id - id.
     * @return boolean.
     */
    private boolean deleteFromMap(TreeMap<Double, LinkedList<Order>> map, int id) {
        Order find = null;
        Double searchValue = null;
        for (Map.Entry<Double, LinkedList<Order>> entry : map.entrySet()) {
            for (Order order : entry.getValue()) {
                if (order.getOrderId() == id) {
                    find = order;
                    break;
                }
            }
            if (find != null) {
                entry.getValue().remove(find);
                if (entry.getValue().isEmpty()) {
                    searchValue = entry.getKey();
                }
                break;
            }
        }
        if (searchValue != null) {
            map.remove(searchValue);
        }
        return find == null;
    }

    /**
     * method adjustSell.
     * @param sell - order sell.
     * @return order.
     */
    private Order adjustSell(Order sell) {
        ArrayList<Double> priceToDelete = new ArrayList<>();
        for (Map.Entry<Double, LinkedList<Order>> entry : bidOrders.entrySet()) {
            if (entry.getKey() >= sell.getPrice()) {
                LinkedList<Order> list = entry.getValue();
                Iterator<Order> iter = list.iterator();
                while (iter.hasNext() && sell.getVolume() != 0) {
                    Order order = iter.next();
                    if (order.getVolume() > sell.getVolume()) {
                        order.setVolume(order.getVolume() - sell.getVolume());
                        sell.setVolume(0);
                    } else {
                        sell.setVolume(sell.getVolume() - order.getVolume());
                        iter.remove();
                    }
                    if (list.isEmpty()) {
                        priceToDelete.add(entry.getKey());
                    }
                }
            }
        }
        if (!priceToDelete.isEmpty()) {
            for (Double price : priceToDelete) {
                bidOrders.remove(price);
            }
        }
        return sell.getVolume() > 0 ? sell : null;
    }

    /**
     * mathod adjustBuy.
     * @param buy - order buy.
     * @return order.
     */
    private Order adjustBuy(Order buy) {
        ArrayList<Double> priceToDelete = new ArrayList<>();
        for (Map.Entry<Double, LinkedList<Order>> entry : askOrders.entrySet()) {
            if (entry.getKey() <= buy.getPrice()) {
                LinkedList<Order> list = entry.getValue();
                Iterator<Order> iter = list.iterator();
                while (iter.hasNext() && buy.getVolume() != 0) {
                    Order order = iter.next();
                    if (order.getVolume() > buy.getVolume()) {
                        order.setVolume(order.getVolume() - buy.getVolume());
                        buy.setVolume(0);
                    } else {
                        buy.setVolume(buy.getVolume() - order.getVolume());
                        iter.remove();
                    }
                }
                if (list.isEmpty()) {
                    priceToDelete.add(entry.getKey());
                }
            }
        }
        if (!priceToDelete.isEmpty()) {
            for (Double price : priceToDelete) {
                askOrders.remove(price);
            }
        }
        return buy.getVolume() > 0 ? buy : null;
    }

    /**
     * method show.
     */
    public void show() {
        System.out.println("Book name:" + orderBookName);
        System.out.println("BID              ASK");
        System.out.println("volume@price  -  volume@price");
        Iterator<Map.Entry<Double, LinkedList<Order>>> iterAsk = askOrders.entrySet().iterator();
        Iterator<Map.Entry<Double, LinkedList<Order>>> iterBid = bidOrders.entrySet().iterator();
        for (int i = 0; i < askOrders.size() || i < bidOrders.size(); i++) {
            System.out.println(orderString(iterBid) + " - " + orderString(iterAsk));
        }
    }

    /**
     * method orderString.
     * @param iterator - iterator.
     * @return string.
     */
    private String orderString(Iterator<Map.Entry<Double, LinkedList<Order>>> iterator) {
        StringBuilder str = new StringBuilder();
        if (iterator.hasNext()) {
            Map.Entry<Double, LinkedList<Order>> entry = iterator.next();
            Double price = entry.getKey();
            LinkedList<Order> order = entry.getValue();
            Integer bidVolume = getAgregatedVolume(order);
            str.append(bidVolume).append("@").append(price);
        } else {
            str.append("-------");
        }
        return str.toString();
    }

    /**
     * method getAgregatedVolume.
     * @param list - list.
     * @return Integer.
     */
    private Integer getAgregatedVolume(LinkedList<Order> list) {
        Integer sum = 0;
        for (Order order : list) {
            sum += order.getVolume();
        }
        return sum;
    }
}