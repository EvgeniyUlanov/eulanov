package ru.job4j.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryStore {

    private final static SessionFactoryStore FACTORY_STORE = new SessionFactoryStore();
    private final SessionFactory factory;

    private SessionFactoryStore() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactoryStore getInstance() {
        return FACTORY_STORE;
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
