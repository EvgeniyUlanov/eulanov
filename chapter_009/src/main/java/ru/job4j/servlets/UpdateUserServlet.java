package ru.job4j.servlets;

import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {

    private UserStore userStore = UserStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setRole(req.getParameter("role"));
        user.setCountry(req.getParameter("country"));
        user.setCity(req.getParameter("city"));
        userStore.updateUser(req.getParameter("oldLogin"), user);
    }
}
