package ru.job4j.map;

import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * class UserTest.
 */
public class UserTest {
    @Test
    public void twoUserWithTheSameAttributes() {
        User user = new User("Georgy", 2, new GregorianCalendar(1985, 7, 11));
        User user2 = new User("Georgy", 2, new GregorianCalendar(1985, 7, 11));

        Map<User, String> map = new HashMap<>();
        map.put(user, "first");
        map.put(user2, "second");

        System.out.println(map);
    }
}
