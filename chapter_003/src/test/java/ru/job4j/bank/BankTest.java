package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class for testing bank class.
 *
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class BankTest {
    /**
     * tests addUser metod.
     */
    @Test
    public void whenAddUserToBankThanBankConteinUser() {
        Bank bank = new Bank();
        User user = new User("Andrey", "4515 455456");
        bank.addUser(user);
        assert (bank.contains(user));
    }

    /**
     * tests deleteUser metod.
     */
    @Test
    public void whenDeleteUserFromBankThanBankDoNotConteinUser() {
        Bank bank = new Bank();
        User user = new User("Andrey", "4515 455456");
        bank.addUser(user);
        assert (bank.contains(user));
        bank.deleteUser(user);
        assert (!bank.contains(user));
    }

    /**
     * tests addAccountToUser metod.
     * @throws WrongAccountException - exception.
     */
    @Test
    public void whenAddAccountToUserInBankThanUserHaveThisAccount() throws WrongAccountException {
        Bank bank = new Bank();
        User user = new User("Andrey", "4515 455456");
        Account account = new Account("14500 4565 4587");
        bank.addUser(user);
        assert (bank.addAccountToUser(user, account));
        assert (user.getAccounts().contains(account));
    }

    /**
     * tests addAccountToUser metod throw exception.
     * @throws WrongAccountException - exception.
     */
    @Test (expected = WrongAccountException.class)
    public void whenAddAccountToUserIfThisAccountBelongsAnotherUserThanException() throws WrongAccountException {
        Bank bank = new Bank();
        User firstUser = new User("Andrey", "4515 455456");
        User secondUser = new User("Konroy", "7845 987455");
        Account account = new Account("14500 4565 4587");
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        bank.addAccountToUser(firstUser, account);
        bank.addAccountToUser(secondUser, account);
    }

    /**
     * tests deleteAccountFromUser metod.
     * @throws WrongAccountException - exception.
     */
    @Test
    public void whenDeleteAccountFromUserInBankThanUserDoNotHaveThisAccount() throws WrongAccountException {
        Bank bank = new Bank();
        User user = new User("Andrey", "4515 455456");
        Account account = new Account("14500 4565 4587");
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        assert (bank.deleteAccountFromUser(user, account));
        assert (!user.getAccounts().contains(account));
        assert (!bank.deleteAccountFromUser(user, account));
    }
    /**
     * tests getAccounts from user.
     * @throws WrongAccountException - exception.
     */
    @Test
    public void whenBankHaveUserThanGetAccountReturnAccoutsOfUser() throws WrongAccountException {
        Bank bank = new Bank();
        User user = new User("Oleg", "4778 989898");
        Account firstAccount = new Account("78451 4545 9898");
        Account secondAccount = new Account("78455 8787 5454");
        bank.addUser(user);
        bank.addAccountToUser(user, firstAccount);
        bank.addAccountToUser(user, secondAccount);
        List<Account> userAccounts = bank.getAccounts(user);
        List<Account> expected = new ArrayList<>();
        expected.add(firstAccount);
        expected.add(secondAccount);
        assertThat(expected.containsAll(userAccounts), is(true));
    }

    /**
     * test transfer from user to another user.
     * @throws WrongAccountException - exception.
     */
    @Test
    public void whenTryTransferValueFromUserAccountThanTrue() throws WrongAccountException {
        Bank bank = new Bank();
        User firstUser = new User("Andrey", "7845 989845");
        User secondUser = new User("Nikolay", "1245 784512");
        Account firstAccount = new Account("45781 5487 9632", 300D);
        Account secondAccount = new Account("78451 2451 7845", 300D);
        Account thirdAccount = new Account("12457 8965 3214");
        bank.addAccountToUser(firstUser, firstAccount);
        bank.addAccountToUser(firstUser, secondAccount);
        bank.addAccountToUser(secondUser, thirdAccount);
        assert (bank.transfer(firstUser, firstAccount, secondUser, thirdAccount, 100));
        assert (thirdAccount.getValue() == 100D);
    }

    /**
     * test transfer from user account to another user account.
     * @throws WrongAccountException - exception.
     */
    @Test
    public void whenTryTransferValueFromUserAccountToAnotherUserAccountThanTrue() throws WrongAccountException {
        Bank bank = new Bank();
        User user = new User("Andrey", "7845 989845");
        Account firstAccount = new Account("45781 5487 9632", 300D);
        Account secondAccount = new Account("78451 2451 7845", 300D);
        bank.addAccountToUser(user, firstAccount);
        bank.addAccountToUser(user, secondAccount);
        assert (bank.transfer(user, firstAccount, secondAccount, 100));
        assert (secondAccount.getValue() == 400D);
        assert (firstAccount.getValue() == 200D);
    }

    /**
     * test transfer from user to another user, when account is not exist, or not enougt mpney.
     * @throws WrongAccountException - exception.
     */
    @Test
    public void whenTryTransferValueFromUserAccountThanFalse() throws WrongAccountException {
        Bank bank = new Bank();
        User firstUser = new User("Andrey", "7845 989845");
        User secondUser = new User("Nikolay", "1245 784512");
        Account firstAccount = new Account("45781 5487 9632");
        Account secondAccount = new Account("78451 2451 7845");
        Account thirdAccount = new Account("12457 8965 3214");
        Account foursAccount = null;
        bank.addAccountToUser(firstUser, firstAccount);
        bank.addAccountToUser(firstUser, secondAccount);
        bank.addAccountToUser(secondUser, thirdAccount);
        assert (!bank.transfer(firstUser, firstAccount, secondUser, thirdAccount, 100));
        assert (!bank.transfer(firstUser, foursAccount, secondAccount, 100D));
    }

    /**
     * test transfer from user to another user.
     * @throws WrongAccountException - exception.
     */
    @Test (expected = WrongAccountException.class)
    public void whenTryTransferValueFromAccountDoesNotBelongsToUserThanException() throws WrongAccountException {
        Bank bank = new Bank();
        User firstUser = new User("Andrey", "7845 989845");
        User secondUser = new User("Nikolay", "1245 784512");
        Account firstAccount = new Account("45781 5487 9632", 300D);
        Account secondAccount = new Account("78451 2451 7845", 300D);
        Account thirdAccount = new Account("12457 8965 3214");
        bank.addAccountToUser(firstUser, firstAccount);
        bank.addAccountToUser(firstUser, secondAccount);
        bank.addAccountToUser(secondUser, thirdAccount);
        bank.transfer(firstUser, thirdAccount, secondUser, firstAccount, 100);
    }
}