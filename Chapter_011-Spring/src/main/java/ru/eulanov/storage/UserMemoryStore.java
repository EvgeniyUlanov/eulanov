package ru.eulanov.storage;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMemoryStore implements Store<User> {

    private List<User> users = new ArrayList<>();
    private Integer counter = 0;

    @Override
    public void add(User user) {
        user.setId(counter.toString());
        counter++;
        users.add(user);
    }

    @Override
    public User getById(String id) {
        return users.stream().filter(e -> e.getId().equals(id)).findFirst().orElseGet(User::new);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
