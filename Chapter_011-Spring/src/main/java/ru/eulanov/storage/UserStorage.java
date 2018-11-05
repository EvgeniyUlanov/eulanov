package ru.eulanov.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserStorage {

    @Autowired
    private Store<User> store;

    public void add(User user) {
        store.add(user);
    }

    public List<User> getAll() {
        return store.getAll();
    }

    public User getById(String id) {
        return store.getById(id);
    }

    public Store<User> getStore() {
        return store;
    }

    public void setStore(Store<User> store) {
        this.store = store;
    }
}