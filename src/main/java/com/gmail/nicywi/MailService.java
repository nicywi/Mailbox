package com.gmail.nicywi;

import java.util.ArrayList;
import java.util.List;

public class MailService {

    private final List<Inbox> inboxes = new ArrayList<>();
    private final List<Mail> mails = new ArrayList<Mail>();

    public void send(Mail mail) {
        mails.add(mail);
    }
    public List<Mail> getReceivedEmails (User user){

        List<Mail> receivedEmails = new ArrayList<>();

        for (Mail mail: mails) {
            if(mail.getReceiver().getLogin().equals(user.getLogin())){
                receivedEmails.add(mail);
            }
        }
        return receivedEmails;
    }

    public List<Mail> getSentEmails (User user){

        List<Mail> sentEmails = new ArrayList<>();

        for (Mail mail: mails) {
            if(mail.getSender().getLogin().equals(user.getLogin())){
                sentEmails.add(mail);
            }
        }
        return sentEmails;
    }



    public List<Inbox> getInboxes() {
        return inboxes;
    }

    public List<Mail> getMails() {
        return mails;
    }
}
