package ru.eulanov.storage;

import java.util.List;

public interface Store<T> {

    void add(T entity);

    T getById(String id);

    List<T> getAll();
}
