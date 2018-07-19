package ru.job4j.jdbc;

import org.slf4j.*;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;

public class Test {

    private static final Logger LOG = LoggerFactory.getLogger(Test.class);
    private Connection conn;

    public void start(String host, String dbName, String user, String password, int numberN) {
        String url = String.format("jdbc:postgresql://localhost:%s/%s", host, dbName);
        try {
            conn = DriverManager.getConnection(url, user, password);
            preparing();
            insertInTable(numberN);
            try {
                selectFromTable();
            } catch (Exception e) {
                System.out.println("Not good with select into file");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Test test = new Test();
        test.start("5432", "my_db", "postgres", "784512963", 10);
    }

    private void preparing() {
        if (conn != null) {
            try (Statement st = conn.createStatement()) {
                st.executeUpdate("CREATE TABLE IF NOT EXISTS Test (field int)");
                st.executeUpdate("DELETE FROM Test");
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    private void insertInTable(int number) {
        if (conn != null) {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO Test VALUES (?)")) {
                for (int i = 0; i < number; i++) {
                    st.setInt(1, i);
                    st.executeUpdate();
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    private void selectFromTable() throws IOException, XMLStreamException {
        File file = new File("1.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(Files.newOutputStream(file.toPath()));
        try {
            writer.writeStartDocument();
            writer.writeStartElement("Entries");
            if (conn != null) {
                try (PreparedStatement st = conn.prepareStatement("SELECT * FROM Test")) {
                    try (ResultSet rs = st.executeQuery()) {
                        while (rs.next()) {
                            writer.writeStartElement("Entry");
                            writer.writeStartElement("Field");
                            String str = "" + rs.getInt("field");
                            writer.writeCharacters(str);
                            writer.writeEndElement();
                            writer.writeEndElement();
                            System.out.println(rs.getInt("field"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Not good");
                        //log.error(e.getMessage(), e);
                    }
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            writer.close();
        }
    }
}