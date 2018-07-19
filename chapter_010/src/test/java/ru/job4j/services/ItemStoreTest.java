package ru.job4j.services;

import org.junit.Test;
import ru.job4j.models.Item;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ItemStoreTest {
    @Test
    public void testAddGetDeleteUpdateItem() {
        Item item = new Item();
        item.setName("some item");
        item.setDescription("description for some item");
        ItemStore.getInstance().addItem(item);
        Item resolved = ItemStore.getInstance().getItem(item.getId());

        assertTrue(resolved.getName().equals(item.getName()));

        item.setName("new name");
        ItemStore.getInstance().updateItem(item);
        resolved = ItemStore.getInstance().getItem(item.getId());

        assertTrue(resolved.getName().equals("new name"));

        ItemStore.getInstance().deleteItem(resolved);

        assertTrue(ItemStore.getInstance().getItem(resolved.getId()) == null);
    }

    @Test
    public void testGetAllItems() {
        Item first = new Item();
        first.setName("first item");
        Item second = new Item();
        second.setName("second item");
        ItemStore.getInstance().addItem(first);
        ItemStore.getInstance().addItem(second);
        List<Item> items = ItemStore.getInstance().getAll();

        assertTrue(items.contains(first));
        assertTrue(items.contains(second));
    }
}