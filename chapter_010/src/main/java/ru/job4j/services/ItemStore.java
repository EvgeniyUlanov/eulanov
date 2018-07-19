package ru.job4j.services;

import org.hibernate.Session;
import ru.job4j.models.Item;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ItemStore {

    private static final ItemStore ITEM_STORE = new ItemStore();

    private ItemStore() {
    }

    public static ItemStore getInstance() {
        return ITEM_STORE;
    }

    public void addItem(Item item) {
        try (Session session = SessionFactoryStore.getInstance().getFactory().openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
    }

    public List<Item> getAll() {
        try (Session session = SessionFactoryStore.getInstance().getFactory().openSession()) {
            CriteriaBuilder builder = SessionFactoryStore.getInstance().getFactory().getCriteriaBuilder();
            CriteriaQuery<Item> criteriaQuery = builder.createQuery(Item.class);
            Root<Item> root = criteriaQuery.from(Item.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).list();
        }
    }

    public void updateItem(Item item) {
        try (Session session = SessionFactoryStore.getInstance().getFactory().openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    public void deleteItem(Item item) {
        try (Session session = SessionFactoryStore.getInstance().getFactory().openSession()) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }

    public Item getItem(long id) {
        Item item;
        try (Session session = SessionFactoryStore.getInstance().getFactory().openSession()) {
            session.beginTransaction();
            item = session.get(Item.class, id);
            session.getTransaction().commit();
        }
        return item;
    }
}
