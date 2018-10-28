package ru.job4j.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * class Bank.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Bank {
    /** users.*/
    private Map<User, List<Account>> users;

    /**
     * constructor.
     */
    public Bank() {
        users = new HashMap<>();
    }

    /**
     * method addUser.
     * @param user - user.
     */
    public void addUser(User user) {
        users.put(user, user.getAccounts());
    }

    /**
     * method deleteUser.
     * @param user - user.
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * method addAccountToUser.
     * @param user - user
     * @param account - account
     * @return boolean.
     * @throws WrongAccountException - exception.
     */
    public boolean addAccountToUser(User user, Account account) throws WrongAccountException {
        if (account.checkOcupied()) {
            throw new WrongAccountException("This account is occupied.");
        }
        account.setOccupied();
        return user.setAccount(account);
    }

    /**
     * method deleteAccount.
     * @param user - user.
     * @param account - acoount.
     * @return boolean
     */
    public boolean deleteAccountFromUser(User user, Account account) {
        return user.removeAccount(account);
    }

    /**
     * method getAccount.
     * @param user - user
     * @return list.
     */
    public List<Account> getAccounts(User user) {
        return user.getAccounts();
    }

    /**
     * method transfer.
     * @param sourceUser - user
     * @param sourceAccount - account
     * @param destUser - user
     * @param destAccount - account
     * @param amount - amount
     * @return boolean.
     * @throws WrongAccountException - exception.
     */
    public boolean transfer(User sourceUser, Account sourceAccount, User destUser, Account destAccount, double amount)
            throws WrongAccountException {
        if (sourceAccount == null || destAccount == null) {
            return false;
        }
        if (!sourceUser.getAccounts().contains(sourceAccount)
                || !destUser.getAccounts().contains(destAccount)) {
            throw new WrongAccountException("Account does not belong user");
        }
        return sourceAccount.getValue() > amount && sourceAccount.takeValue(amount) && destAccount.addValue(amount);
    }

    /**
     * method transfer from user account to another user account.
     * @param user - user.
     * @param sourceAccount - source account.
     * @param destAccount - dest account.
     * @param amount - value.
     * @return boolean
     * @throws WrongAccountException - exception.
     */
    public boolean transfer(User user, Account sourceAccount, Account destAccount, double amount)
            throws WrongAccountException {
        if (sourceAccount == null || destAccount == null) {
            return false;
        }
        if (!user.getAccounts().contains(sourceAccount)
                || !user.getAccounts().contains(destAccount)) {
            throw new WrongAccountException("Account does not belong user");
        }
        return sourceAccount.getValue() > amount && sourceAccount.takeValue(amount) && destAccount.addValue(amount);
    }

    /**
     * method contains.
     * @param user - user.
     * @return boolean.
     */
    public boolean contains(User user) {
        return users.containsKey(user);
    }
}
