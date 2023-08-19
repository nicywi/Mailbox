package com.gmail.nicywi;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user1 = new User ("John", "john@gmail.com");
        Inbox inbox1 = new Inbox(user1);
        User user2 = new User ("Anna", "anna@gmail.com");
        Inbox inbox2 = new Inbox(user2);

        Mail mail1 = new Mail ("Wedding invitation", "Hi Anna blabla",LocalDate.now());
        Mail mail2 = new Mail ("Wedding reply", "Hi John blabla",LocalDate.now());

    }

    public void send(User sender, User receiver, Mail mail){


    }
}