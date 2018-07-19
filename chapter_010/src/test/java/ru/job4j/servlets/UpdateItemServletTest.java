package ru.job4j.servlets;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.services.ItemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateItemServletTest {
    @Test
    public void testWhenClientSendUpdatedItemThenItemUpdateInItemStore() throws IOException, ServletException {
        ItemStore itemStore = mock(ItemStore.class);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        UpdateItemServlet servlet = new UpdateItemServlet();
        servlet.setItemStore(itemStore);
        String itemJson = "{\"id\":1,\"name\":\"new item\",\"description\":\"description\"}";
        when(req.getReader()).thenReturn(
                new BufferedReader(new InputStreamReader(new ByteArrayInputStream(itemJson.getBytes())))
        );

        servlet.doPost(req, resp);

        Item item = new Item();
        item.setId(1);
        item.setName("new item");
        item.setDescription("description");

        verify(itemStore).updateItem(eq(item));
    }
}
