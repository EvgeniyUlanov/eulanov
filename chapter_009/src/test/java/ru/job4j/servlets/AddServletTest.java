package ru.job4j.servlets;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * class to test AddNewUserServlet.
 */
public class AddServletTest {

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

    /**
     * test for doPost method.
     * when add new user than this user exist in DB, then redirect to "/".
     * @throws ServletException - servlet exception.
     * @throws IOException - io exception.
     */
    @Test
    public void addNewUserTest() throws ServletException, IOException {
        AddNewUserServlet servlet = new AddNewUserServlet();

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        String itemJson = "{\"name\":\"new user\",\"login\":\"user login\",\"email\":\"email\"}";
        when(req.getReader()).thenReturn(
                new BufferedReader(new InputStreamReader(new ByteArrayInputStream(itemJson.getBytes())))
        );

        servlet.doPost(req, resp);

        User user = userStore.getUser("new user");

        assertThat(user.getLogin(), is("user login"));
    }
}
