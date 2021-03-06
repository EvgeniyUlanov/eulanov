package ru.job4j.map;

import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * class UserTest.
 */
public class UserTest {
    /**
     * test without overriding.
     */
    @Test
    public void twoUserWithTheSameAttributes() {
        User user = new User("Georgy", 2, new GregorianCalendar(1985, 7, 11));
        User user2 = new User("Georgy", 2, new GregorianCalendar(1985, 7, 11));

        Map<User, String> map = new HashMap<>();
        map.put(user, "first");
        map.put(user2, "second");

        System.out.println(map);
    }

    /**
     * test with override hashCode.
     */
    @Test
    public void twoUserWithTheSameAttributesHashCodeIsOverride() {
        UserHash user = new UserHash("Georgy", 2, new GregorianCalendar(1985, 7, 11));
        UserHash user2 = new UserHash("Georgy", 2, new GregorianCalendar(1985, 7, 11));

        Map<UserHash, String> map = new HashMap<>();
        map.put(user, "first");
        map.put(user2, "second");

        System.out.println(map);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
    }

    /**
     * test with override equals.
     */
    @Test
    public void twoUserWithTheSameAttributesEqualsIsOverride() {
        UserEquals user = new UserEquals("Georgy", 2, new GregorianCalendar(1985, 7, 11));
        UserEquals user2 = new UserEquals("Georgy", 2, new GregorianCalendar(1985, 7, 11));

        Map<UserEquals, String> map = new HashMap<>();
        map.put(user, "first");
        map.put(user2, "second");

        System.out.println(map);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
    }

    /**
     * test with override hashCode and equals.
     */
    @Test
    public void twoUserWithTheSameAttributesHashCodeAndEqualsIsOverride() {
        UserEqualsHash user = new UserEqualsHash("Georgy", 2, new GregorianCalendar(1985, 7, 11));
        UserEqualsHash user2 = new UserEqualsHash("Georgy", 9, new GregorianCalendar(1985, 7, 11));
        UserEqualsHash user3 = new UserEqualsHash("Andrey", 9, new GregorianCalendar(1985, 7, 11));

        Map<UserEqualsHash, String> map = new HashMap<>();
        map.put(user, "first");
        map.put(user2, "second");

        System.out.println(map);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user.equals(user2));

        System.out.println((16 - 1) & (user.hashCode() ^ (user.hashCode() >>> 16)));
        System.out.println((16 - 1) & (user2.hashCode() ^ (user2.hashCode() >>> 16)));
        System.out.println((16 - 1) & (user3.hashCode() ^ (user3.hashCode() >>> 16)));
    }
}
