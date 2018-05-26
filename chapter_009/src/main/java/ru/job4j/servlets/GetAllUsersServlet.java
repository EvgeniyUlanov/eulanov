package ru.job4j.servlets;

import com.google.gson.Gson;
import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllUsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserStore.getInstance().getAll();
        Gson gson = new Gson();
        String usersGson = gson.toJson(users);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(usersGson);
    }
}
