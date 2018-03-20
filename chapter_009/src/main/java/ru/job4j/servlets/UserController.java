package ru.job4j.servlets;

import ru.job4j.connectionpool.DBConnectionPool;
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
     * method add new User: use name, login, email as parameter.
     * @param req - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", UserStore.getInstance().getAll());
        req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
    }

    /**
     * method shows all users.
     * @param req - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * method create connection and table.
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
