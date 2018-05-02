package ru.job4j.servlets;

import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Signin extends HttpServlet {

    /**
     * method redirect to sign in page.
     * @param req - request
     * @param resp - response
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/SigninView.jsp").forward(req, resp);
    }

    /**
     * method check user and set role and login in session then redirect to user controller.
     * if user not found or password invalid than redirect to doGet method.
     * @param req - request
     * @param resp - response
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = UserStore.getInstance().getUserByLogin(login);
        if (user != null && login.equals(user.getLogin()) && password.equals(user.getPassword())) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
                session.setAttribute("role", user.getRole());
                resp.sendRedirect(String.format("%s/", req.getContextPath()));
            }
        } else {
            req.getRequestDispatcher("/WEB-INF/views/SigninView.jsp").forward(req, resp);
        }
    }
}
