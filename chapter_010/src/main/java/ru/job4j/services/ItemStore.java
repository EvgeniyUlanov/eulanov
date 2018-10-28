package ru.job4j.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.job4j.models.Item;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Function;

public class ItemStore {

    private static final ItemStore ITEM_STORE = new ItemStore();
    private SessionFactory factory;

    private ItemStore() {
        factory = SessionFactoryStore.getInstance().getFactory();
    }

    public static ItemStore getInstance() {
        return ITEM_STORE;
    }

    public void addItem(Item item) {
        tx(session -> session.save(item));
    }

    public List<Item> getAll() {
        return tx(session -> {
            CriteriaBuilder builder = factory.getCriteriaBuilder();
            CriteriaQuery<Item> criteriaQuery = builder.createQuery(Item.class);
            Root<Item> root = criteriaQuery.from(Item.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).list();
        });
    }

    public void updateItem(Item item) {
        tx(session -> {
            session.update(item);
            return item;
        });
    }

    public void deleteItem(Item item) {
        tx(session -> {
            session.delete(item);
            return item;
        });
    }

    public Item getItem(long id) {
        return tx(session -> session.get(Item.class, id));
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
