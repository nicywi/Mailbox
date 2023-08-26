package com.gmail.nicywi;

import java.util.ArrayList;
import java.util.List;

public class MailService {
    //private final List<Inbox> inboxes = new ArrayList<>();
    private final List<Mail> mails = new ArrayList<>();

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

    public void deleteReceivedEmails(User user) {
        mails.removeAll(mails.stream()
                .filter(mail -> mail.getReceiver().getLogin().equals(user.getLogin()))
                .toList());
    }

    public void deleteSentEmails(User user) {
        mails.removeAll(mails.stream()
                .filter(mail -> mail.getSender().getLogin().equals(user.getLogin()))
                .toList());
    }

    public void deleteOneSentEmail(User user, String tytulMaila) {
        mails.removeAll(mails.stream().filter(mail -> mail.getSender().getLogin().equals(user.getLogin())).filter(mail -> mail.getTitle().equals(tytulMaila)).toList());
    }

    public List<Mail> getMails() {
        return mails;
    }
}
