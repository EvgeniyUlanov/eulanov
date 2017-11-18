package ru.job4j.nonblock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * class NonBlockCash.
 */
public class NonBlockCash {
    /** data.*/
    private ConcurrentHashMap<Integer, Model> data = new ConcurrentHashMap<>();

    /**
     * method add.
     * @param model - model to add.
     */
    public void add(Model model) {
        data.putIfAbsent(model.getId(), model);
    }

    /**
     * method delete.
     * @param id - id.
     * @return boolean.
     */
    public boolean delete(Integer id) {
        return data.remove(id) != null;
    }

    /**
     * method getModel.
     * @param id - id.
     * @return model.
     */
    public Model getModel(Integer id) {
        return data.get(id);
    }

    /**
     * method update.
     * @param model - model.
     */
    public void update(Model model) {
        Integer id = model.getId();
        int version = data.get(id).getVersion();
        data.computeIfPresent(id, (key, oldModel) -> {
            if (version != model.getVersion()) {
                throw new OptimisticException("Exception");
            }
            model.upDateVersion();
            return model;
        });
    }

    /**
     * method toString.
     * @return string.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Integer, Model> model : data.entrySet()) {
            str.append(model.getValue().toString()).append("\n");
        }
        return str.toString();
    }
}

/**
 * class OptimisticException.
 */
class OptimisticException extends RuntimeException {
    /**
     * constructor.
     * @param msg - message.
     */
    OptimisticException(String msg) {
        super(msg);
    }
}

/**
 * class Rename.
 */
class Rename implements Runnable {
    /** cash.*/
    private NonBlockCash cash;

    /**
     * constructor.
     * @param cash - cash.
     */
    Rename(NonBlockCash cash) {
        this.cash = cash;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Model model = cash.getModel(i);
            try {
                model.setName(String.format("Model was renamed by %s", Thread.currentThread().getName()));
                cash.update(model);
            } catch (OptimisticException e) {
                System.out.println("Can't update model " + model.getId());
            }
        }
    }
}