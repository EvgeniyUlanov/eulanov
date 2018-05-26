package ru.job4j.users;

import com.google.gson.Gson;
import ru.job4j.connectionpool.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesStore {

    private final static CountriesStore COUNTRIES_STORE = new CountriesStore();

    /**
     * constructor.
     */
    private CountriesStore() {
        try {
            Class.forName("ru.job4j.connectionpool.DBConnectionPool");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static CountriesStore getInstance() {
        return COUNTRIES_STORE;
    }

    public List<String> getAllCountries() {
        List<String> countries = new ArrayList<>();
        try (Connection conn = DBConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM countries;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cityName = rs.getString("country");
                countries.add(cityName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
