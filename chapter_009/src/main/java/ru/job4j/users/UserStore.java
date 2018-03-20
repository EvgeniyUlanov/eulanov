package ru.job4j.users;

import ru.job4j.connectionpool.DBConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    /** instance of user store.*/
    private final static UserStore USER_STORE = new UserStore();

    /**
     * constructor.
     */
    private UserStore() {
        try {
            Class.forName("ru.job4j.connectionpool.DBConnectionPool");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method return instance of user store.
     * @return - UserStore.
     */
    public static UserStore getInstance() {
        return USER_STORE;
    }

    /**
     * method create table users.
     */
    public void createTable() {
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Users (name VARCHAR(255) NOT NULL, "
                    + "login VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(255), "
                    + "createDate TIMESTAMP)");
            st.executeUpdate("DELETE FROM Users");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method add user to db.
     * @param user - user to add.
     */
    public synchronized boolean addUser(User user) {
        boolean result = false;
        User userToCheck = UserStore.getInstance().getUser(user.getName());
        if (userToCheck == null) {
            try (Connection conn = DBConnectionPool.getDataSource().getConnection();
                 PreparedStatement st = conn.prepareStatement("INSERT INTO users VALUES (?, ?, ?, current_timestamp)")) {
                st.setString(1, user.getName());
                st.setString(2, user .getLogin());
                st.setString(3, user.getEmail());
                result = st.executeUpdate() == 1;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * method delete user from db.
     * @param name - user name.
     */
    public synchronized boolean deleteUser(String name) {
        boolean result = false;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st = conn.prepareStatement("DELETE FROM Users WHERE name = (?)")) {
            st.setString(1, name);
            result = st.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * method update user in db.
     * @param user - user.
     */
    public synchronized boolean updateUser(User user) {
        boolean result = false;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st =
                     conn.prepareStatement("UPDATE Users SET login = (?), email = (?) WHERE name = (?)")) {
            st.setString(1, user.getLogin());
            st.setString(2, user.getEmail());
            st.setString(3, user.getName());
            result = st.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * method return user from db.
     * @param name - user name.
     * @return user.
     */
    public synchronized User getUser(String name) {
        User user = null;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st =
                     conn.prepareStatement("SELECT * FROM Users WHERE name = (?)")) {
            st.setString(1, name);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String userName = rs.getString("name");
                    String login = rs.getString("login");
                    String email = rs.getString("email");
                    Timestamp createDate = rs.getTimestamp("createDate");
                    user = new User(userName, login, email);
                    user.setDate(createDate);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * method return list of users.
     * @return list.
     */
    public synchronized List<User> getAll() {
        List<User> result = null;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM Users")) {
            result = new ArrayList<>();
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String login = rs.getString("login");
                    String email = rs.getString("email");
                    Timestamp createDate = rs.getTimestamp("createDate");
                    User user = new User(name, login, email);
                    user.setDate(createDate);
                    result.add(user);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}