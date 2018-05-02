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

public class UserControllerTest {

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
    public void whenRoleAdminThanRedirectToAdminPage() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        UserController controller = new UserController();

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("admin");
        when(session.getAttribute("login")).thenReturn("mike");
        when(req.getRequestDispatcher("/WEB-INF/views/AdminView.jsp")).thenReturn(dispatcher);

        controller.doGet(req, resp);

        verify(req).setAttribute("currentUser", "mike");
        verify(req).setAttribute("users", UserStore.getInstance().getAll());
        verify(req).getRequestDispatcher("/WEB-INF/views/AdminView.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    public void whenRoleNotAdminThanRedirectToUserPage() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        UserController controller = new UserController();

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("user");
        when(session.getAttribute("login")).thenReturn("user");
        when(req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp")).thenReturn(dispatcher);

        controller.doGet(req, resp);

        verify(req).getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    public void whenUserDoesNotExistInDbThanRedirectToSignOut() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        UserController controller = new UserController();

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("user");
        when(session.getAttribute("login")).thenReturn("notExist");
        when(req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp")).thenReturn(dispatcher);

        controller.doGet(req, resp);

        verify(resp).sendRedirect(String.format("%s/signout", req.getContextPath()));
    }
}