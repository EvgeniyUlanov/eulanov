package ru.job4j.servlets;

import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewUserServlet extends HttpServlet {

    private UserStore userStore = UserStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        if (name != null && login != null && !name.equals("") && !login.equals("")) {
            String email = req.getParameter("email");
            User user = new User(name, login, email);
            user.setPassword(req.getParameter("password"));
            user.setRole(req.getParameter("role"));
            user.setCountry(req.getParameter("country"));
            user.setCity(req.getParameter("city"));
            userStore.addUser(user);
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}