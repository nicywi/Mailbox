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
        for (:
             ) {
            
        }
    }



    public List<Inbox> getInboxes() {
        return inboxes;
    }

    public List<Mail> getMails() {
        return mails;
    }
}
