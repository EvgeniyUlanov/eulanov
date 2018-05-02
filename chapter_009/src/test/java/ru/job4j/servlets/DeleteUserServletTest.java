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

public class DeleteUserServletTest {

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
    }

    @Test
    public void whenDoPostThanExistingUserDeleteFromStoreAndRedirectToStart() throws ServletException, IOException {
        DeleteUserServlet deleteUserServlet = new DeleteUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        User user = new User("peter", "login", "email");

        userStore.addUser(user);
        Assert.assertThat(userStore.getUser("peter"), is(user));

        when(req.getParameter("login")).thenReturn("login");

        deleteUserServlet.doPost(req, resp);
        User expected = null;

        verify(resp).sendRedirect(String.format("%s/", req.getContextPath()));
        Assert.assertThat(userStore.getUser("peter"), is(expected));
    }
}
