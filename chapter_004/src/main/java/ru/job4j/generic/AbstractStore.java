package ru.job4j.generic;

/**
 * class AbstractStore.
 * @param <T> - type.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /** conteiner.*/
    private SimpleArray<T> elementData = new SimpleArray<>();

    /**
     * metod add.
     * @param model - model.
     * @return model.
     */
    @Override
    public T add(T model) {
        elementData.add(model);
        return model;
    }

    /**
     * metod update.
     * @param model - model.
     * @return old value.
     */
    @Override
    public T update(T model) {
        T oldValue = null;
        for (T value : elementData) {
            if (value.getId().equals(model.getId())) {
                oldValue = value;
                value = model;
            }
        }
        return oldValue;
    }

    /**
     * metod delete.
     * @param model - model.
     * @return boolean.
     * @throws WrongPositionException - exception.
     */
    @Override
    public boolean delete(T model) throws WrongPositionException {
        for (int i = 0; i < elementData.size(); i++) {
            if (elementData.get(i) == model) {
                elementData.delete(i);
                return true;
            }
        }
        return false;
    }
}
