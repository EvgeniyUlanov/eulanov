package ru.job4j.servlets;

import com.google.gson.Gson;
import ru.job4j.services.ItemStore;
import ru.job4j.utils.MyUtil;
import ru.job4j.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class AddItemServlet extends HttpServlet {

    private ItemStore itemStore;

    @Override
    public void init() throws ServletException {
        itemStore = ItemStore.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String incomingString = MyUtil.getIncomingStringFromRequest(req);
        Gson gson = new Gson();
        Item item = gson.fromJson(incomingString, Item.class);
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        itemStore.addItem(item);
    }

    public ItemStore getItemStore() {
        return itemStore;
    }

    public void setItemStore(ItemStore itemStore) {
        this.itemStore = itemStore;
    }
}
