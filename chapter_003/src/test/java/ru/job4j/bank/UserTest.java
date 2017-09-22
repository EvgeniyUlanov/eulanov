package ru.job4j.bank;

import java.util.List;
//import java.util.ArrayList;
import org.junit.Test;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;

/**
 * class for testing user class.
 *
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class UserTest {

    /**
     * metod tests equals.
     */
    @Test
    public void whenUserEqualsAnotherUserThanTrue() {
        User user1 = new User("Andrey", "1509 456089");
        User user2 = new User("Andrey", "1509 456089");
        assert (user1.equals(user2));
    }

    /**
     * metod tests hashCode.
     */
    @Test
    public void whenUserEqualsAnotherUserThanHashCodeTrue() {
        User user1 = new User("Andrey", "1509 456089");
        User user2 = new User("Andrey", "1509 456089");
        assert (user1.hashCode() == user2.hashCode());
    }

    /**
     * metod tests getAccount, setAccount, removeAccount.
     */
    @Test
    public void whenUserHasThisAccountThanReturnTrueAndFalseIfNot() {
        User user = new User("Andrey", "1509 456089");
        Account account1 = new Account("11154 5004 4554");
        user.setAccount(account1);
        List<Account> accounts = user.getAccounts();
        assert (user.getAccounts().contains(account1));
        user.removeAccount(account1);
        assert (!user.getAccounts().contains(account1));
    }
}
