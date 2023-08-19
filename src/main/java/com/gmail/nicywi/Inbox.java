package com.gmail.nicywi;

import java.util.List;

public class Inbox {

    User user;
    List<Mail> received;
    List<Mail> sent;

    public Inbox(User user) {
        this.user = user;
    }
}
