package ru.job4j.monitore;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class UserStorageTest
 */
public class UserStorageTest {
    /**
     * test method add, findUser.
     */
    @Test
    public void whenAddUserThanFindUserReturnUser() {
        UserStorage storage = new UserStorage();
        User userFirst = new User(1, 100);

        storage.add(userFirst);

        assertThat(storage.findUser(userFirst.getId()), is(userFirst));
    }

    /**
     * test method delete.
     */
    @Test
    public void whenDeleteUserThanFindUserReturnNull() {
        UserStorage storage = new UserStorage();
        User userFirst = new User(1, 100);

        storage.add(userFirst);
        storage.delete(userFirst.getId());
        User result = null;

        assertThat(storage.findUser(userFirst.getId()), is(result));
    }

    /**
     * test method upDate.
     */
    @Test
    public void whenUpdateThanUserInStorageIsUserWithSameIdAndNewAmount() {
        UserStorage storage = new UserStorage();
        User userFirst = new User(1, 100);
        User userUpdate = new User(1, 150);

        storage.add(userFirst);
        storage.upDate(userUpdate);

        assertThat(storage.findUser(userFirst.getId()).getAmount(), is(150));
    }

    /**
     * test method transfer.
     */
    @Test
    public void whenTransferValueBetweenUsersThanAmountChangedIfNotEnothAmountThanNothingChanges() {
        UserStorage storage = new UserStorage();
        User userFirst = new User(1, 100);
        User userSecond = new User(2, 150);

        storage.add(userFirst);
        storage.add(userSecond);
        storage.transfer(1, 2, 50);

        assertThat(userFirst.getAmount(), is(50));
        assertThat(userSecond.getAmount(), is(200));
        assertThat(storage.transfer(1, 2, 150), is(false));
        assertThat(userFirst.getAmount(), is(50));
        assertThat(userSecond.getAmount(), is(200));
    }

    /**
     * test using negative value.
     */
    @Test
    public void whenUsingNegativeNumberWithMethodTransferThanNothigChanged() {
        UserStorage storage = new UserStorage();
        User userFirst = new User(1, 100);
        User userSecond = new User(2, 150);

        storage.add(userFirst);
        storage.add(userSecond);
        storage.transfer(1, 2, -20);

        assertThat(userFirst.getAmount(), is(100));
        assertThat(userSecond.getAmount(), is(150));
    }
}
