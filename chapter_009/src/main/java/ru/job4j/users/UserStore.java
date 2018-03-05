package ru.job4j.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    /** instance of user store.*/
    private final static UserStore USER_STORE = new UserStore();
//    private static final Logger LOGGER  = LoggerFactory.getLogger(UserStore.class);
    /** db connection.*/
    private Connection conn;

    /**
     * constructor.
     */
    private UserStore() {
    }

    /**
     * method return instance of user store.
     * @return - UserStore.
     */
    public static UserStore getUserStore() {
        return USER_STORE;
    }

    /**
     * method create connection to db.
     * @param url - url.
     * @param user - user.
     * @param password - password.
     */
    public void connectToDb(String url, String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method close db connection.
     */
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
//                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * method create table users.
     */
    public void createTable() {
        if (conn != null) {
            try (Statement st = conn.createStatement()) {
                int i = st.executeUpdate("CREATE TABLE IF NOT EXISTS Users (name VARCHAR(255) NOT NULL, "
                        + "login VARCHAR(255) NOT NULL, "
                        + "email VARCHAR(255), "
                        + "createDate TIMESTAMP)");
                int j = st.executeUpdate("DELETE FROM Users");
                System.out.println(i);
                System.out.println(j);
            } catch (SQLException e) {
                e.printStackTrace();
//                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * method add user to db.
     * @param user - user to add.
     */
    public boolean addUser(User user) {
        boolean result = false;
        User userToCheck = UserStore.getUserStore().getUser(user.getName());
        if (conn != null && userToCheck == null) {
            try (PreparedStatement st =
                         conn.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, current_timestamp)")) {
                st.setString(1, user.getName());
                st.setString(2, user .getLogin());
                st.setString(3, user.getEmail());
                result = st.executeUpdate() == 1;
            } catch (SQLException e) {
//                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * method delete user from db.
     * @param name - user name.
     */
    public boolean deleteUser(String name) {
        boolean result = false;
        if (conn != null) {
            try (PreparedStatement st =
                         conn.prepareStatement("DELETE FROM Users WHERE name = (?)")) {
                st.setString(1, name);
                result = st.executeUpdate() == 1;
            } catch (SQLException e) {
//                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * method update user in db.
     * @param user - user.
     */
    public boolean updateUser(User user) {
        boolean result = false;
        if (conn != null) {
            try (PreparedStatement st =
                         conn.prepareStatement("UPDATE Users SET login = (?), email = (?) WHERE name = (?)")) {
                st.setString(1, user.getLogin());
                st.setString(2, user.getEmail());
                st.setString(3, user.getName());
                result = st.executeUpdate() == 1;
            } catch (SQLException e) {
//                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * method return user from db.
     * @param name - user name.
     * @return user.
     */
    public User getUser(String name) {
        User user = null;
        if (conn != null) {
            try (PreparedStatement st =
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
            } catch (SQLException e) {
//                LOGGER.error(e.getMessage(), e);
            }
        }
        return user;
    }

    /**
     * method return list of users.
     * @return list.
     */
    public List<User> getAll() {
        List<User> result = null;
        if (conn != null) {
            try (PreparedStatement st =
                         conn.prepareStatement("SELECT * FROM Users")) {
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
            } catch (SQLException e) {
//                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }
}