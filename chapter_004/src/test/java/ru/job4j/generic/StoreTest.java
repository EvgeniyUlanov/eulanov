package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * tests.
 */
public class StoreTest {
    /**
     * test metods add, delete.
     * @throws WrongPositionException - exception.
     */
    @Test
    public void whenStoreHaveUserThanDeleteUserIsTrue() throws WrongPositionException {
        UserStore userStore = new UserStore();
        User user1 = new User("123");

        userStore.add(user1);

        assertThat(userStore.delete(user1), is(true));
    }
}
