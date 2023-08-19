package com.gmail.nicywi;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private Map<String, User> users = new HashMap<>();

    public void addUser(String login, String password, String name, String emailAdress) {
        if (!users.containsKey(login)) {
            User user = new User(login, password, name, emailAdress);
            users.put(login, user);
            System.out.println("Rejestracja loginu przebiegła pomyślnie");
        } else {
            System.out.println("Login już istnieje");
        }
    }

    public boolean login(String login, String password) {
        if (users.containsKey(login)) {
            User user = users.get(login);
            return user.getPassword().equals(password);
        }
        return false;
    }
}

