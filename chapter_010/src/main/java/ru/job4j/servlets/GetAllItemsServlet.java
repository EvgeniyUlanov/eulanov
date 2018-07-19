package ru.job4j.servlets;

import com.google.gson.Gson;
import ru.job4j.services.ItemStore;
import ru.job4j.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllItemsServlet extends HttpServlet {

    private ItemStore itemStore;

    @Override
    public void init() throws ServletException {
        itemStore = ItemStore.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = itemStore.getAll();
        Gson gson = new Gson();
        String itemsJson = gson.toJson(items);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(itemsJson);
    }

    public ItemStore getItemStore() {
        return itemStore;
    }

    public void setItemStore(ItemStore itemStore) {
        this.itemStore = itemStore;
    }
}
