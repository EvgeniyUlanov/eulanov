package ru.job4j.servlets;

import ru.job4j.connectionpool.DBConnectionPool;
import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {

    private UserStore userStore;

    /**
     * method redirect request to user or admin page, if user not found then sign out.
     *
     * @param req  - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException      - exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("role").equals("admin")) {
            req.setAttribute("currentUser", req.getSession().getAttribute("login"));
            req.setAttribute("users", UserStore.getInstance().getAll());
            req.getRequestDispatcher("/WEB-INF/views/AdminView.jsp").forward(req, resp);
        } else {
            User user = UserStore.getInstance().getUserByLogin((String) req.getSession().getAttribute("login"));
            if (user != null) {
                req.setAttribute("currentUser", user);
                req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(String.format("%s/signout", req.getContextPath()));
            }
        }
    }

    /**
     * method redirect to doGet method.
     *
     * @param req  - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException      - exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * method create connection and table.
     *
     * @param config - config
     * @throws ServletException - exceotion
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userStore = UserStore.getInstance();
        userStore.createTable();
    }

    /**
     * method close connection.
     */
    @Override
    public void destroy() {
        super.destroy();
        DBConnectionPool.closeConnection();
    }
}
