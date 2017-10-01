package ru.job4j.generic;

/**
 * interface Store.
 * @param <T> - type.
 */
public interface Store<T extends Base> {

    /**
     * metod add.
     * @param model - model.
     * @return T.
     */
    T add(T model);

    /**
     * metod update.
     * @param model - model.
     * @return T.
     */
    T update(T model);

    /**
     * metod delete.
     * @param model - model.
     * @return boolean.
     * @throws WrongPositionException - exception.
     */
    boolean delete(T model) throws WrongPositionException;
}
