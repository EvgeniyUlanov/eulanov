package ru.job4j.testtask;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * class BookParserSax.
 */
public class BookParserSax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        File file = new File("orders.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(file, handler);
        for (Map.Entry<String, OrderBook> entry : handler.getResult().entrySet()) {
            entry.getValue().show();
        }
    }
}

class MyHandler extends DefaultHandler {

    private TreeMap<String, OrderBook> orderbooks = new TreeMap<>();

    public TreeMap<String, OrderBook> getResult() {
        return orderbooks;
    }
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("AddOrder")) {
            String bookName = attributes.getValue(0);
            Integer id = Integer.valueOf(attributes.getValue(4));
            String operationType = attributes.getValue(1);
            Float price = Float.valueOf(attributes.getValue(2));
            Integer volume = Integer.valueOf(attributes.getValue(3));
            Order order = new Order(id, operationType, price, volume);
            if (orderbooks.containsKey(bookName)) {
                orderbooks.get(bookName).add(order);
            } else {
                OrderBook orderBook = new OrderBook(bookName);
                orderBook.add(order);
                orderbooks.put(bookName, orderBook);
            }
            System.out.println(id);
        } else if(qName.equals("DeleteOrder")) {
            //String bookName = attributes.getValue(0);
            //Integer id = Integer.valueOf(attributes.getValue(1));
            //orderbooks.get(bookName).delete(id);
        }
    }
}
