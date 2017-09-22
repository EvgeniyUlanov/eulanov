package ru.job4j.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
//import java.util.ArrayList;

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
        users = new HashMap<User, List<Account>>();
    }

    /**
     * metod addUser.
     * @param user - user.
     */
    public void addUser(User user) {
        users.put(user, user.getAccounts());
    }

    /**
     * metod deleteUser.
     * @param user - user.
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * metod addAccountToUser.
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
     * metod deleteAccount.
     * @param user - user.
     * @param account - acoount.
     * @return boolean
     */
    public boolean deleteAccountFromUser(User user, Account account) {
        return user.removeAccount(account);
    }

    /**
     * metod getAccount.
     * @param user - user
     * @return list.
     */
    public List<Account> getAccounts(User user) {
        return user.getAccounts();
    }

    /**
     * metod transfer.
     * @param sourseUser - user
     * @param sourseAccount - account
     * @param destUser - user
     * @param destAccount - account
     * @param amount - amount
     * @return boolean.
     * @throws WrongAccountException - exception.
     */
    public boolean transfer(User sourseUser, Account sourseAccount, User destUser, Account destAccount, double amount)
            throws WrongAccountException {
        if (sourseAccount == null || destAccount == null) {
            return false;
        }
        if (!sourseUser.getAccounts().contains(sourseAccount)
                || !destUser.getAccounts().contains(destAccount)) {
            throw new WrongAccountException("Account does not belong user");
        }
        return sourseAccount.getValue() > amount && sourseAccount.takeValue(amount) && destAccount.addValue(amount);
    }

    /**
     * metod transfer from user account to another user account.
     * @param user - user.
     * @param sourseAccount - sourse account.
     * @param destAccount - dest account.
     * @param amount - value.
     * @return boolean
     * @throws WrongAccountException - exception.
     */
    public boolean transfer(User user, Account sourseAccount, Account destAccount, double amount)
            throws WrongAccountException {
        if (sourseAccount == null || destAccount == null) {
            return false;
        }
        if (!user.getAccounts().contains(sourseAccount)
                || !user.getAccounts().contains(destAccount)) {
            throw new WrongAccountException("Account does not belong user");
        }
        return sourseAccount.getValue() > amount && sourseAccount.takeValue(amount) && destAccount.addValue(amount);
    }

    /**
     * metod conteins.
     * @param user - user.
     * @return boolean.
     */
    public boolean conteins(User user) {
        return users.containsKey(user);
    }
}
