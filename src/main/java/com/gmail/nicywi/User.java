package com.gmail.nicywi;

public class User {
    private String name;
    private String emailAddress;
    private String login;
    private String password;

    public User(String name, String emailAddress, String login, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.login = login;
        this.password = password;
    }

    public User(String name, String emailAddress, String login) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
