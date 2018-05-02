package ru.job4j.servlets;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SignOutServletTest {

    /**
     * test for method doGet/doPost.
     * when doGet method invokes than redirect to method doPost.
     * doPost method close session and redirect to start.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Test
    public void whenSignOutThanSessionCloseAndRedirect() throws ServletException, IOException {
        SignOut signOut = new SignOut();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(req.getSession()).thenReturn(session);

        signOut.doGet(req, resp);
        signOut.doPost(req, resp);

        verify(req, times(2)).getSession();
        verify(session, times(2)).invalidate();
        verify(resp, times(2)).sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
