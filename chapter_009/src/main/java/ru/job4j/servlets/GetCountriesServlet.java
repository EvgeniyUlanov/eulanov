package ru.job4j.servlets;

import com.google.gson.Gson;
import ru.job4j.users.CountriesStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCountriesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> countries = CountriesStore.getInstance().getAllCountries();
        Gson gson = new Gson();
        String countriesGson = gson.toJson(countries);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(countriesGson);
    }
}
