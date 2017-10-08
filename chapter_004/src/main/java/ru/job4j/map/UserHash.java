package ru.job4j.map;

import java.util.Calendar;

/**
 * class UserHash.
 */
public class UserHash {
    /** name.*/
    private String name;
    /** number of children.*/
    private int children;
    /** birthdate.*/
    private Calendar birthday;

    /**
     * constructor.
     * @param name - name.
     * @param children - children.
     * @param birthday - birthday.
     */
    public UserHash(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * method to string.
     * @return string.
     */
    @Override
    public String toString() {
        return String.format("%s(%s children) - %s.%s.%s", name, children, birthday.get(Calendar.YEAR),
                birthday.get(Calendar.MONTH), birthday.get(Calendar.DATE));
    }

    /**
     * metod hashCode.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + name.hashCode();
        result = result * 31 + children;
        result = result * 31 + birthday.hashCode();
        return result;
    }
}
