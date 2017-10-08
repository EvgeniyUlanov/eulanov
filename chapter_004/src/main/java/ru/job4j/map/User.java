package ru.job4j.map;

import java.util.Calendar;

/**
 * class User.
 */
public class User {
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
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s(%s children) - %s.%s.%s", name, children, birthday.get(Calendar.YEAR),
                birthday.get(Calendar.MONTH), birthday.get(Calendar.DATE));
    }
}
