package ru.job4j.testtask;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * class BookParser.
 */
public class BookParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("orders.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();

        TreeMap<String, OrderBook> orderBooks = new TreeMap<>();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element) {

                //long time = System.nanoTime();
                //long cur = 0;
                //long end = 0;

                Element childElement = (Element) child;
                String action = childElement.getTagName();
                String bookName = childElement.getAttribute("book");
                Integer id = Integer.valueOf(childElement.getAttribute("orderId"));
                if (action.equals("AddOrder")) {
                    String operationType = childElement.getAttribute("operation");
                    Float price = Float.valueOf(childElement.getAttribute("price"));
                    Integer volume = Integer.valueOf(childElement.getAttribute("volume"));

                    //cur = System.nanoTime();

                    Order order = new Order(id, operationType, price, volume);

                    OrderBook book = orderBooks.get(bookName);
                    if (book == null) {
                        book = new OrderBook(bookName);
                        orderBooks.put(bookName, book);
                    }
                    book.add(order);

                    //end = System.nanoTime();
                    System.out.println(id);

                } else if (action.equals("DeleteOrder")) {
                    //orderBooks.get(bookName).delete(id);
                    System.out.println(id);
                }

            }
        }

        for (Map.Entry<String, OrderBook> entry : orderBooks.entrySet()) {
            entry.getValue().show();
        }
    }
}
