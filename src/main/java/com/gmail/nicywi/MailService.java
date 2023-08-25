package com.gmail.nicywi;

import java.util.ArrayList;
import java.util.List;

public class MailService {
    private final List<Inbox> inboxes = new ArrayList<>();
    private final List<Mail> mails = new ArrayList<Mail>();

    public void send(Mail mail) {
        mails.add(mail);
        System.out.println("Mail został wysłany");
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
    public String deleteRecivedEmails(User user) {
        List <Mail> operationList = mails.stream()
                .filter(mail -> mail.getReceiver().getLogin().equals(user.getLogin()))
                .toList();
        mails.removeAll(operationList);
        return "Maile zostały usunięte";
    }

    public String deleteSentEmails(User user) {
        mails.removeAll(mails.stream()
                .filter(mail -> mail.getSender().getLogin().equals(user.getLogin()))
                .toList());
        return "Maile zostały usunięte";
    }

    public List<Inbox> getInboxes() {
        return inboxes;
    }

    public List<Mail> getMails() {
        return mails;
    }
}
