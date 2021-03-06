package ru.job4j.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

public class MyUtil {
    public static String getIncomingStringFromRequest(HttpServletRequest req) {
        StringBuilder incomingString = new StringBuilder();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                incomingString.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incomingString.toString();
    }
}
