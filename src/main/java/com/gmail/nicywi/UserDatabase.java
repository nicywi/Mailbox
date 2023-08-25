package com.gmail.nicywi;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.nicywi.Main.newUser;

public class UserDatabase {
    private Map<String, User> users = new HashMap<>();

    public boolean addUserTest(String name, String emailAdress, String login, String password) {
        if (!users.containsKey(login)) {
            User user = new User(name, emailAdress, login, password);
            users.put(login, user);
            return true;
        } else {
            return false;
        }
    }

    public User loginTest(String login, String password) {
        if (users.containsKey(login)) {
            User user = users.get(login);
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return newUser();
    }

    public Map<String, User> getUsers() {
        return users;
    }
}

