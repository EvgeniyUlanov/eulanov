package ru.job4j.compare;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class for test SortUser class.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class SortUserTest {
    /**
     * test for check comparable in class User.
     */
    @Test
    public void whenUserIsElderThenAnotherUserThenTrue() {
        User oleg = new User("Oleg", 25);
        User valera = new User("Valera", 20);
        assertThat(oleg.compareTo(valera), is(1));
    }

    /**
     * test for metod sort.
     */
    @Test
    public void whenListSortThanTreeSetIsSortedByAge() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(new User[]{new User("Sergey", 25),
                                              new User("Ivan", 24),
                                              new User("Andrey", 30),
                                              new User("Oleg", 18),
                                              new User("Ilia", 18)}));
        Set<User> sortedUsers = SortUser.sort(users);
        Set<User> expectedTree = new TreeSet<>();
        expectedTree.addAll(users);
        for (User user : users) {
            assert (expectedTree.contains(user));
        }
    }
}