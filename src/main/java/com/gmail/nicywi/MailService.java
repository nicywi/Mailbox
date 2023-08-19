package com.gmail.nicywi;

import java.util.ArrayList;
import java.util.List;

public class MailService {

   private final List<Inbox> inboxes = new ArrayList<>();
   private final List<Inbox> mails = new ArrayList<>();

    public void send(Mail mail){

    }

    public List<Inbox> getInboxes() {
        return inboxes;
    }

    public List<Inbox> getMails() {
        return mails;
    }
}
