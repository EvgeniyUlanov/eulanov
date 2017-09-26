package ru.job4j.bank;

import org.junit.Test;

/**
 * class for testing account class.
 *
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class AccountTest {
    /**
     * metod tests add value.
     */
    @Test
    public void whenAddPositiveValueThanTrueIfNotThanFalse() {
        Account account = new Account("15450 4545 6565");
        account.setOccupied();
        double currentValue = account.getValue();
        boolean bool = account.addValue(100D);
        double changedValue = account.getValue();
        assert (bool && changedValue - currentValue == 100D);
        assert (!account.addValue(-100D) && account.getValue() == 100D);
    }

    /**
     * metod tests take value.
     */
    @Test
    public void whenTakePositiveValueAddEnougtMoneyThanTrueIfNotThanFalse() {
        Account account = new Account("15450 4545 6565");
        account.setOccupied();
        boolean bool = account.takeValue(100D);
        assert (!bool && account.getValue() == 0);
        account.addValue(200D);
        double currentValue = account.getValue();
        bool = account.takeValue(100D);
        double changedValue = account.getValue();
        assert (bool && currentValue - changedValue == 100D);
        assert (!account.takeValue(-100D) && account.getValue() == 100D);
    }
}
