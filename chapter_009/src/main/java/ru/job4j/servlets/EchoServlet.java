package ru.job4j.servlets;

import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EchoServlet extends HttpServlet {

//    private static final Logger LOGGER  = LoggerFactory.getLogger(EchoServlet.class);
    private UserStore userStore;
    private final static String URL = "jdbc:postgresql://localhost:5432/my_db";

    /**
     * method add new User: use name, login, email as parameter.
     * @param req - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(name, login, email);
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (userStore.addUser(user)) {
            writer.append("Add new user ").append(name);
        } else {
            writer.append("Cannot add user");
        }
        writer.flush();
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
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<User> userList = userStore.getAll();
        if (userList != null && userList.size() != 0) {
            for (User user : userList) {
                writer.append(user.toString()).append("\n");
            }
        } else {
            writer.append("Nothing to show");
        }
        writer.flush();
    }

    /**
     * method update user.
     * @param req - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(name, login, email);
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (userStore.updateUser(user)) {
            writer.append(String.format("User %s was updated", name));
        } else {
            writer.append("Cannot update user");
        }
        writer.flush();
    }

    /**
     * method delete user.
     * @param req - req
     * @param resp - resp
     * @throws ServletException - exception
     * @throws IOException - exception
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (userStore.deleteUser(name)) {
            writer.append(String.format("User %s was deleted", name));
        } else {
            writer.append("Cannot delete user");
        }
        writer.flush();
    }

    /**
     * method create connection and table.
     * @param config - config
     * @throws ServletException - exceotion
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userStore = UserStore.getUserStore();
        userStore.connectToDb(URL, "postgres", "784512963");
        userStore.createTable();
    }

    /**
     * method close connection.
     */
    @Override
    public void destroy() {
        super.destroy();
        userStore.closeConnection();
    }
}
