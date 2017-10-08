package ru.job4j.map;

import java.util.Calendar;

/**
 * class UserHash.
 */
public class UserEquals {
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
    public UserEquals(String name, int children, Calendar birthday) {
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
     * metod equals.
     * @param o - object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else if (o instanceof UserEquals) {
            UserEquals cp = (UserEquals) o;
            result = this.name.equals(cp.name) && this.children == cp.children && this.birthday.equals(cp.birthday);
        }
        return result;
    }
}
