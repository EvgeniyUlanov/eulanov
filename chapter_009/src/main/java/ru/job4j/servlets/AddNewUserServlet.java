package ru.job4j.servlets;

import com.google.gson.Gson;
import ru.job4j.users.User;
import ru.job4j.users.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class AddNewUserServlet extends HttpServlet {

    private UserStore userStore = UserStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder incommingString = new StringBuilder();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                incommingString.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        User user = gson.fromJson(incommingString.toString(), User.class);
        userStore.addUser(user);
    }
}