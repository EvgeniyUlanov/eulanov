package ru.job4j.servlets;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.services.ItemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetAllItemsServletTest {
    @Test
    public void testWhenDoGetMethodThenResponseToClientListOfItemsFromItemStore() throws IOException, ServletException {
        ItemStore itemStore = mock(ItemStore.class);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        GetAllItemsServlet servlet = new GetAllItemsServlet();
        PrintWriter writer = mock(PrintWriter.class);
        servlet.setItemStore(itemStore);
        Item item = new Item();
        item.setId(1);
        item.setName("item name");
        item.setDescription("item description");
        when(itemStore.getAll()).thenReturn(Arrays.asList(item));
        when(resp.getWriter()).thenReturn(writer);

        servlet.doGet(req, resp);

        verify(writer).write("[{\"id\":1,\"name\":\"item name\",\"description\":\"item description\",\"done\":false}]");
    }
}
