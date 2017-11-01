package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * class UserStorage.
 */
@ThreadSafe
public class UserStorage {
    /** storage to keep users.*/
    @GuardedBy("this") private TreeMap<Integer, User> storage = new TreeMap<>();

    /**
     * method add.
     * @param user - user.
     */
    public void add(User user) {
        synchronized (this) {
            storage.put(user.getId(), user);
        }
    }

    /**
     * method delete.
     * @param id - id.
     */
    public void delete(int id) {
        synchronized (this) {
            storage.remove(id);
        }
    }

    /**
     * method findUser.
     * @param id - id.
     * @return user.
     */
    public User findUser(int id) {
        return storage.get(id);
    }

    /**
     * method upDate.
     * @param user - user.
     * @return boolean.
     */
    public boolean upDate(User user) {
        synchronized (this) {
            boolean result = false;
            if (storage.containsKey(user.getId())) {
                add(user);
                result = true;
            }
            return result;
        }
    }

    /**
     * method transfer.
     * @param idFrom - id user from.
     * @param idTo - id user to.
     * @param value - value.
     * @return boolean.
     */
    public boolean transfer(int idFrom, int idTo, int value) {
        synchronized (this) {
            boolean result = false;
            User userFrom = storage.get(idFrom);
            User userTo = storage.get(idTo);
            if (userFrom != null && userTo != null) {
                if (userFrom.takeValue(value)) {
                    result = userTo.addValue(value);
                }
            }
            return result;
        }
    }

    /**
     * method toString.
     * @return string.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Integer, User> entry : storage.entrySet()) {
            str.append(entry.getValue()).append("\n");
        }
        return str.toString();
    }
}
