package ru.job4j.servlets;

import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    private UserStore userStore = UserStore.getUserStore();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        userStore.deleteUser(name);
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
