package ru.eulanov.starage;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.eulanov.storage.User;
import ru.eulanov.storage.UserStorage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserStorageTestWithAnnotation {
    private static ApplicationContext context;

    @BeforeClass
    public static void initContext() {
        context = new ClassPathXmlApplicationContext("spring-annotation-context.xml");
    }

    @Test
    public void testAddUser() {
        UserStorage storage = context.getBean(UserStorage.class);
        User user = new User("ivan");
        storage.add(user);
        assert user.getId().equals("0");
    }

    @Test
    public void testGetUserById() {
        UserStorage storage = context.getBean(UserStorage.class);
        User user = new User("evgen");
        storage.add(user);
        User expected = storage.getById(user.getId());
        assertThat(expected, is(user));
    }

    @Test
    public void testGetAll() {
        UserStorage storage = context.getBean(UserStorage.class);
        User nikolay = new User("nokolay");
        User vasia = new User("vasia");
        storage.add(nikolay);
        storage.add(vasia);
        List<User> expected = storage.getAll();
        assert expected.contains(nikolay);
        assert expected.contains(vasia);
    }
}
