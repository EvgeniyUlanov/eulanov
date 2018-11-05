package ru.eulanov.storage;

public class User {

    private String id;
    private String name;

    public User() {
        id = "";
        name = "";
    }

    public User(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User - " + name;
    }
}
