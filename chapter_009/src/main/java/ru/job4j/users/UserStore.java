package ru.job4j.users;

import ru.job4j.connectionpool.DBConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    /**
     * instance of user store.
     */
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
     *
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
            st.executeUpdate("DROP TABLE IF EXISTS roles");
            st.executeUpdate("DROP TABLE IF EXISTS users");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS roles (role_id INTEGER PRIMARY KEY, "
                    + "role_name VARCHAR(10));");
            st.executeUpdate("INSERT INTO roles (role_id, role_name) VALUES (1, 'user');");
            st.executeUpdate("INSERT INTO roles (role_id, role_name) VALUES (2, 'admin');");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS users (name VARCHAR(255) PRIMARY KEY, "
                    + "login VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(255), "
                    + "createDate TIMESTAMP, "
                    + "password VARCHAR(255), "
                    + "role_id INTEGER);");
            st.executeUpdate("INSERT INTO users (name, login, email, role_id, password, createdate) "
                    + "VALUES ('mike', 'admin', 'email', (SELECT role_id FROM roles WHERE role_name='admin'), "
                    + "'1234', current_timestamp);");
            st.executeUpdate("INSERT INTO users (name, login, email, role_id, password, createdate) "
                    + "VALUES ('ivan', 'user', 'email', (SELECT role_id FROM roles WHERE role_name='user'), "
                    + "'1', current_timestamp);");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method add user to db.
     *
     * @param user - user to add.
     */
    public synchronized boolean addUser(User user) {
        boolean result = false;
        User userToCheck = UserStore.getInstance().getUserByLogin(user.getLogin());
        if (userToCheck == null) {
            try (Connection conn = DBConnectionPool.getDataSource().getConnection();
                 PreparedStatement st =
                         conn.prepareStatement("INSERT INTO users (name, login, email, createdate, role_id, password) "
                                 + "VALUES (?, ?, ?, current_timestamp, (SELECT role_id FROM roles WHERE role_name=?), ?)")) {
                st.setString(1, user.getName());
                st.setString(2, user.getLogin());
                st.setString(3, user.getEmail());
                st.setString(4, user.getRole());
                st.setString(5, user.getPassword());
                result = st.executeUpdate() == 1;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * method delete user from db.
     *
     * @param login - user login.
     */
    public synchronized boolean deleteUser(String login) {
        boolean result = false;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE login = (?)")) {
            st.setString(1, login);
            result = st.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * method update user in db.
     *
     * @param oldLogin
     * @param user - user.
     */
    public synchronized boolean updateUser(String oldLogin, User user) {
        boolean result = false;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st =
                     conn.prepareStatement("UPDATE users SET name = ?, "
                             + "login=?, "
                             + "email = ?, "
                             + "password = ?, "
                             + "role_id = (SELECT role_id FROM roles WHERE role_name = ?) "
                             + "WHERE login = ?")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setString(5, user.getRole());
            st.setString(6, oldLogin);
            result = st.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * method return user from db.
     *
     * @param name - user name.
     * @return user.
     */
    public synchronized User getUser(String name) {
        User user = null;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st =
                     conn.prepareStatement("SELECT name, login, email, createDate, role_name, password FROM users "
                             + "INNER JOIN roles ON users.role_id=roles.role_id WHERE name = (?)")) {
            st.setString(1, name);
            user = findWithStatement(st);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public synchronized User getUserByLogin(String login) {
        User user = null;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st =
                     conn.prepareStatement("SELECT name, login, email, createDate, role_name, password FROM users "
                             + "INNER JOIN roles ON users.role_id=roles.role_id WHERE login = (?)")) {
            st.setString(1, login);
            user = findWithStatement(st);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User findWithStatement(PreparedStatement st) throws SQLException {
        User user = null;
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String userName = rs.getString("name");
                String userLogin = rs.getString("login");
                String email = rs.getString("email");
                Timestamp createDate = rs.getTimestamp("createDate");
                String role = rs.getString("role_name");
                String password = rs.getString("password");
                user = new User(userName, userLogin, email);
                user.setDate(createDate);
                user.setRole(role);
                user.setPassword(password);
            }
        }
        return user;
    }

    /**
     * method return list of users.
     *
     * @return list.
     */
    public synchronized List<User> getAll() {
        List<User> result = null;
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement st = conn.prepareStatement("SELECT name, login, email, createDate, role_name, password FROM users "
                     + "INNER JOIN roles ON users.role_id=roles.role_id")) {
            result = new ArrayList<>();
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String login = rs.getString("login");
                    String email = rs.getString("email");
                    Timestamp createDate = rs.getTimestamp("createDate");
                    String password = rs.getString("password");
                    String role = rs.getString("role_name");
                    User user = new User(name, login, email);
                    user.setDate(createDate);
                    user.setPassword(password);
                    user.setRole(role);
                    result.add(user);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}