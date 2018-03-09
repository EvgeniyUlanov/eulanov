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
import java.io.PrintWriter;

public class EchoServlet extends HttpServlet {

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
        resp.setContentType("text/html");
        StringBuilder str = new StringBuilder();
        str.append("<table>");
            str.append("<tr>"
                    + "<th>user name</th>"
                    + "<th>login</th>"
                    + "<th>email</th>"
                    + "<th>date</th>"
                    + "</tr>");
        for (User user : userStore.getAll()) {
            str.append("<tr>"
                    + "<th>" + user.getName() + "</th>"
                    + "<th>" + user.getLogin() + "</th>"
                    + "<th>" + user.getEmail() + "</th>"
                    + "<th>" + user.getDate().toString() + "</th>"
                    + "</tr>");
        }
        str.append("</table>");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<body>"
                    + "<form action='" + req.getContextPath() + "/add' method='post'>"
                    + "Name : <input type='text' name='name'/>"
                    + "Login : <input type='text' name='login'/>"
                    + "Email : <input type='text' name='email'/>"
                    + "<input type='submit' value='add new user'>"
                    + "</form>"
                    + "<form action='" + req.getContextPath() + "/update' method='post'>"
                    + "Name : <input type='text' name='name'/>"
                    + "Login : <input type='text' name='login'/>"
                    + "Email : <input type='text' name='email'/>"
                    + "<input type='submit' value='update user'>"
                    + "</form>"
                    + "<form action='" + req.getContextPath() + "/delete' method='post'>"
                    + "Name : <input type='text' name='name'/>"
                    + "<input type='submit' value='delete user'>"
                    + "</form>"
                    + "<form action='" + req.getContextPath() + "/echo' method='post'>"
                    + "<input type='submit' value='show all users'/><br/>"
                    + "</form>"
                    + str.toString()
                + "</body>"
                + "</head>"
                + "</html>");
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
        doGet(req, resp);
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
