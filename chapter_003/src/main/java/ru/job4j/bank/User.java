package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
/**
 * class User.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class User {
    /** name.*/
	private String name;
	/** passport.*/
	private String passport;
	/** accounts.*/
	private List<Account> accounts;

    /**
     * constructor.
     * @param name - name.
     * @param passport - passpor.
     */
	public User(String name, String passport) {
	    this.name = name;
	    this.passport = passport;
	    accounts = new ArrayList<>();
    }

    /**
     * method setAccount.
     * @param account - account.
     * @return boolean.
     */
    boolean setAccount(Account account) {
	    return accounts.add(account);
    }

    /**
     * method removeAccount.
     * @param account - account.
     * @return boolean.
     */
    boolean removeAccount(Account account) {
        return accounts.contains(account) && accounts.remove(account);
    }

    /**
     * method getAccounts.
     * @return accounts.
     */
    List<Account> getAccounts() {
        return accounts;
    }

    /**
     * method equals.
     * @param o - user.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof User) {
            User user = (User) o;
            return this == user || name.equals(user.name) && passport.equals(user.passport);
        } else {
            return false;
        }
    }

    /**
     * method hashCode.
     * @return hashCode.
     */
    public int hashCode() {
        return 37 + name.hashCode() + passport.hashCode();
    }
}