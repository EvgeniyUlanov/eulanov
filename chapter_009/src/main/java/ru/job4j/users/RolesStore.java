package ru.job4j.users;

import ru.job4j.connectionpool.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesStore {

    private final static RolesStore ROLES_STORE = new RolesStore();

    /**
     * constructor.
     */
    private RolesStore() {
        try {
            Class.forName("ru.job4j.connectionpool.DBConnectionPool");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static RolesStore getInstance() {
        return ROLES_STORE;
    }

    public List<String> getAllRoles() {
        List<String> roles = new ArrayList<>();
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cityName = rs.getString("role_name");
                roles.add(cityName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
