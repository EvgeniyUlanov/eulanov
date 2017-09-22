package ru.job4j.bank;

/**
 * class WrongAccountException.
 *
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */
class WrongAccountException extends Exception {
    /**
     * metod AccountException.
     *
     * @param msg - message.
     */
    WrongAccountException(String msg) {
        super(msg);
    }
}