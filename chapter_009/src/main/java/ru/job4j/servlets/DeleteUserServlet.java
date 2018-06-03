package ru.job4j.servlets;

import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    private UserStore userStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginToDelete = req.getParameter("login");
        System.out.println(loginToDelete);
        userStore.deleteUser(req.getParameter("login"));
    }
}
