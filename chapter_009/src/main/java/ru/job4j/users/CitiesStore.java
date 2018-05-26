package ru.job4j.users;

import ru.job4j.connectionpool.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesStore {

    private final static CitiesStore CITIES_STORE = new CitiesStore();

    /**
     * constructor.
     */
    private CitiesStore() {
        try {
            Class.forName("ru.job4j.connectionpool.DBConnectionPool");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static CitiesStore getInstance() {
        return CITIES_STORE;
    }

    public List<String> getAllCities() {
        List<String> cities = new ArrayList<>();
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM cities;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cityName = rs.getString("city");
                cities.add(cityName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
