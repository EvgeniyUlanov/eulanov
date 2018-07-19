package ru.job4j.servlets;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppControllerServletTest {
    @Test
    public void testRedirectToIndexJsp() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        AppControllerServlet servlet = new AppControllerServlet();
        when(req.getRequestDispatcher("/WEB-INF/views/index.jsp")).thenReturn(requestDispatcher);

        servlet.doPost(req, resp);

        verify(requestDispatcher).forward(req, resp);
    }
}
