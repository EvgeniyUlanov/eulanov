package ru.job4j.servlets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateUserServletTest {

    private static UserStore userStore;

    /**
     * method init connection to db.
     */
    @BeforeClass
    public static void createConnectionAndTable() {
        userStore = UserStore.getInstance();
    }

    @Before
    public void createTable() {
        userStore.createTable();
        User user = new User("peter", "login", "email");
        userStore.addUser(user);
    }

    @Test
    public void updateTest() throws ServletException, IOException {
        UpdateUserServlet updateUserServlet = new UpdateUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("oldLogin")).thenReturn("login");
        when(req.getParameter("name")).thenReturn("peter");
        when(req.getParameter("login")).thenReturn("newLogin");
        when(req.getParameter("email")).thenReturn("email");
        when(req.getParameter("password")).thenReturn("159");
        when(req.getParameter("role")).thenReturn("admin");

        updateUserServlet.doPost(req, resp);

        verify(resp).sendRedirect(String.format("%s/", req.getContextPath()));
        User user = userStore.getUser("peter");
        Assert.assertThat(user.getLogin(), is("newLogin"));
    }
}