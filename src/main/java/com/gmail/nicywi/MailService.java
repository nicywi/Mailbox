package com.gmail.nicywi;

import java.util.ArrayList;
import java.util.List;

public class MailService {
    private final List<Inbox> inboxes = new ArrayList<>();
    private final List<Mail> mails = new ArrayList<Mail>();

    public void send(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getReceivedEmails(User user) {
        return mails.stream()
                .filter(mail -> mail.getReceiver().getLogin().equals(user.getLogin()))
                .toList();
    }

    public List<Mail> getSentEmails(User user) {
        return mails.stream()
                .filter(mail -> mail.getSender().getLogin().equals(user.getLogin()))
                .toList();
    }

    public List<Inbox> getInboxes() {
        return inboxes;
    }

    public List<Mail> getMails() {
        return mails;
    }
}
