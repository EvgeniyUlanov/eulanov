package ru.job4j.servlets;

import com.google.gson.Gson;
import ru.job4j.users.CitiesStore;
import ru.job4j.users.CountriesStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCitiesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> cities = CitiesStore.getInstance().getAllCities();
        Gson gson = new Gson();
        String citiesGson = gson.toJson(cities);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(citiesGson);
    }
}
