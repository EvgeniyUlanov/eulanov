package ru.job4j.testtask;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * class OrderBook.
 */
public class OrderBook {

    /** orderbook name.*/
    private String orderBookName;
    /** comparator.*/
    private Comparator<Float> highPrice = new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return o2.compareTo(o1);
        }
    };
    /** tree map for keep ask orders.*/
    private TreeMap<Float, HashMap<Integer, Order>> askOrders = new TreeMap<>();
    /** tree map for keep bid orders.*/
    private TreeMap<Float, HashMap<Integer, Order>> bidOrders = new TreeMap<>(highPrice);

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
        if (orderToAdd.getOperation().equals("SELL")) {
            if (adjustSell(orderToAdd) != null) {
                addToMap(askOrders, orderToAdd);
            }
        } else if (orderToAdd.getOperation().equals("BUY")) {
            if (adjustBuy(orderToAdd) != null) {
                addToMap(bidOrders, orderToAdd);
            }
        }
    }

    /**
     * method addToMap.
     * @param map - map to add order.
     * @param order - order to add.
     */
    private void addToMap(TreeMap<Float, HashMap<Integer, Order>> map, Order order) {
        if (map.containsKey(order.getPrice())) {
            map.get(order.getPrice()).put(order.getOrderId(), order);
        } else {
            HashMap<Integer, Order> newMap = new HashMap<>();
            newMap.put(order.getOrderId(), order);
            map.put(order.getPrice(), newMap);
        }
    }

    /**
     * method adjustSell.
     * @param sell - order sell.
     * @return order.
     */
    private Order adjustSell(Order sell) {
        ArrayList<Float> priceToDelete = new ArrayList<>();
        for (Map.Entry<Float, HashMap<Integer, Order>> entry : bidOrders.entrySet()) {
            if (entry.getKey() >= sell.getPrice()) {
                adjust(entry.getValue(), sell);
            }
            if (entry.getValue().isEmpty()) {
                priceToDelete.add(entry.getKey());
            }
            if (sell.getVolume() == 0) {
                break;
            }
        }
        if (!priceToDelete.isEmpty()) {
            for (Float price : priceToDelete) {
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
        ArrayList<Float> priceToDelete = new ArrayList<>();
        for (Map.Entry<Float, HashMap<Integer, Order>> entry : askOrders.entrySet()) {
            if (entry.getKey() <= buy.getPrice()) {
                adjust(entry.getValue(), buy);
            }
            if (entry.getValue().isEmpty()) {
                priceToDelete.add(entry.getKey());
            }
            if (buy.getVolume() == 0) {
                break;
            }
        }
        if (!priceToDelete.isEmpty()) {
            for (Float price : priceToDelete) {
                askOrders.remove(price);
            }
        }
        return buy.getVolume() > 0 ? buy : null;
    }

    /**
     * method adjust.
     * @param map - map were need to adjust orders.
     * @param orderAdd - order.
     */
    private void adjust(HashMap<Integer, Order> map, Order orderAdd) {
        ArrayList<Integer> orderToDelete = new ArrayList<>();
        for (Map.Entry<Integer, Order> orderEntry : map.entrySet()) {
            Order order = orderEntry.getValue();
            if (order.getVolume() > orderAdd.getVolume()) {
                order.setVolume(order.getVolume() - orderAdd.getVolume());
                orderAdd.setVolume(0);
                break;
            } else {
                orderAdd.setVolume(orderAdd.getVolume() - order.getVolume());
                orderToDelete.add(order.getOrderId());
            }
        }
        for (Integer id : orderToDelete) {
            map.remove(id);
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
    private boolean deleteFromMap(TreeMap<Float, HashMap<Integer, Order>> map, int id) {
        boolean result = false;
        Float searchValue = null;
        for (Map.Entry<Float, HashMap<Integer, Order>> entry : map.entrySet()) {
            result = entry.getValue().remove(id) != null;
            if (result) {
                if (entry.getValue().isEmpty()) {
                    searchValue = entry.getKey();
                }
                break;
            }
        }
        if (searchValue != null) {
            map.remove(searchValue);
        }
        return result;
    }

    /**
     * method findById.
     * @param id - id.
     * @return - order.
     */
    public Order findById(Integer id) {
        Order result = null;
        result = findByIdInMap(id, askOrders);
        if (result == null) {
            result = findByIdInMap(id, bidOrders);
        }
        return result;
    }

    /**
     * method findByIdInMap.
     * @param id - id.
     * @param map - map.
     * @return - order.
     */
    private Order findByIdInMap(Integer id, TreeMap<Float, HashMap<Integer, Order>> map) {
        Order result = null;
        for (Map.Entry<Float, HashMap<Integer, Order>> entryMap : map.entrySet()) {
            result = entryMap.getValue().get(id);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * method show.
     */
    public void show() {
        System.out.println("Book name:" + orderBookName);
        System.out.println("BID              ASK");
        System.out.println("volume@price  -  volume@price");
        Set<Float> askSet = askOrders.keySet();
        Iterator<Float> askIterator = askSet.iterator();
        Set<Float> bidSet = bidOrders.keySet();
        Iterator<Float> bidIterator = bidSet.iterator();
        for (int i = 0; i < askOrders.size() || i < bidOrders.size(); i++) {
            System.out.println(orderString(bidIterator, bidOrders) + " - " + orderString(askIterator, askOrders));
        }
    }

    /**
     * method orderString.
     * @param iterator - iterator.
     * @return string.
     */
    private String orderString(Iterator<Float> iterator, TreeMap<Float, HashMap<Integer, Order>> map) {
        StringBuilder str = new StringBuilder();
        if (iterator.hasNext()) {
            Float price = iterator.next();
            HashMap<Integer, Order> entry = map.get(price);
            Integer sumVolume = getAgregatedVolume(entry);
            str.append(sumVolume).append("@").append(price);
        } else {
            str.append("-------");
        }
        return str.toString();
    }

    /**
     * method getAgregatedVolume.
     * @param map - map.
     * @return Integer.
     */
    private Integer getAgregatedVolume(HashMap<Integer, Order> map) {
        Integer sum = 0;
        for (Map.Entry<Integer, Order> entry : map.entrySet()) {
            sum += entry.getValue().getVolume();
        }
        return sum;
    }

    /**
     * method isEmpty.
     * @return boolean.
     */
    public boolean isEmpty() {
        return askOrders.isEmpty() && bidOrders.isEmpty();
    }
}