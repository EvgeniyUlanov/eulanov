package ru.job4j.testtask;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * class BookParserSax.
 */
public class BookParserSax {

    /**
     * method init.
     * @throws ParserConfigurationException - parser exception.
     * @throws SAXException - sax exception.
     * @throws IOException - input exception.
     */
    private void init() throws ParserConfigurationException, SAXException, IOException {
        File file = new File("orders.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(file, handler);
        for (Map.Entry<String, OrderBook> entry : handler.getResult().entrySet()) {
            entry.getValue().show();
            System.out.println("");
        }
    }

    /**
     * method main.
     * @param args - arguments.
     * @throws ParserConfigurationException - parser exception.
     * @throws SAXException - sax exception.
     * @throws IOException - input exception.
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        long currentTime = System.currentTimeMillis();
        new BookParserSax().init();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Parsing time - %s seconds.", (endTime - currentTime) / 1000));
    }
}

/**
 * class MyHandler.
 */
class MyHandler extends DefaultHandler {
    /** const addorder.*/
    private static final String ADD = "AddOrder";
    /** const deleteorder.*/
    private static final String DELETE = "DeleteOrder";
    /** order books container.*/
    private TreeMap<String, OrderBook> orderbooks = new TreeMap<>();

    /**
     * method getResult.
     * @return book container.
     */
    public TreeMap<String, OrderBook> getResult() {
        return orderbooks;
    }

    /**
     * method startDocument.
     * @throws SAXException - sax exception.
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of parsing");
    }

    /**
     * method endDocument.
     * @throws SAXException - sax exception.
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of parsing");
    }

    /**
     * method startElement.
     * @param uri - uri.
     * @param localName - local name.
     * @param qName - name of element.
     * @param attributes - attributes of element.
     * @throws SAXException - sax exception.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(ADD)) {
            String bookName = attributes.getValue("book");
            Integer id = Integer.valueOf(attributes.getValue("orderId"));
            String operationType = attributes.getValue("operation");
            Float price = Float.valueOf(attributes.getValue("price"));
            Integer volume = Integer.valueOf(attributes.getValue("volume"));
            Order order = new Order(id, operationType, price, volume);
            OrderBook orderBook = new OrderBook(bookName);
            orderbooks.putIfAbsent(bookName, orderBook);
            orderbooks.get(bookName).add(order);
            /*if (orderBook != null) {
                orderBook.add(order);
            } else {
                orderBook = new OrderBook(bookName);
                orderBook.add(order);
                orderbooks.put(bookName, orderBook);
            }*/
        } else if (qName.equals(DELETE)) {
            String bookName = attributes.getValue("book");
            Integer id = Integer.valueOf(attributes.getValue("orderId"));
            orderbooks.get(bookName).delete(id);
        }
    }
}
