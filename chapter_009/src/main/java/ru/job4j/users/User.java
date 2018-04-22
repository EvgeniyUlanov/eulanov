package ru.job4j.users;

import java.sql.Timestamp;

public class User {

    private String name;
    private String login;
    private String email;
    private Timestamp date;
    private String role;
    private String password;

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = "user";
        this.password = "11111";
        this.date = Timestamp.valueOf("2018-04-08 01:02:33.089822");
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role != null) {
            this.role = role;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", date=" + date.toString() + '\''
                + ", role=" + role
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            User user = (User) o;
            if (name != null ? !name.equals(user.name) : user.name != null) {
                result = false;
            } else if (login != null ? !login.equals(user.login) : user.login != null) {
                result = false;
            } else if (email != null ? email.equals(user.email) : user.email == null) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}