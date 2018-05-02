package ru.job4j.servlets;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.users.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SignInServletTest {

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
    public void whenDoGetMethodInvokesThanRedirectToSignInViewJSP() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Signin signin = new Signin();
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(req.getRequestDispatcher("/WEB-INF/views/SigninView.jsp")).thenReturn(requestDispatcher);

        signin.doGet(req, resp);

        verify(req).getRequestDispatcher("/WEB-INF/views/SigninView.jsp");
        verify(requestDispatcher).forward(req, resp);
    }

    @Test
    public void whenRequestContainsRightUserParametersThanRedirectToStart() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        Signin signin = new Signin();

        when(req.getSession()).thenReturn(session);
        when(req.getParameter("login")).thenReturn("admin");
        when(req.getParameter("password")).thenReturn("1234");

        signin.doPost(req, resp);

        verify(session).setAttribute("login", "admin");
        verify(session).setAttribute("role", "admin");
        verify(resp).sendRedirect(String.format("%s/", req.getContextPath()));
    }

    @Test
    public void whenRequestContainsFalseUserParametersThanRedirectSigninViewJSP() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        Signin signin = new Signin();

        when(req.getRequestDispatcher("/WEB-INF/views/SigninView.jsp")).thenReturn(requestDispatcher);

        when(req.getParameter("login")).thenReturn("user");
        when(req.getParameter("password")).thenReturn("1234");

        signin.doPost(req, resp);

        verify(req).getRequestDispatcher("/WEB-INF/views/SigninView.jsp");
    }
}
