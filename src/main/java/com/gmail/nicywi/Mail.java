package com.gmail.nicywi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Mail {
    private String title;
    private String description;
    private LocalDateTime date;
    private User sender;
    private User receiver;

    public Mail(String title, String description, LocalDateTime date, User sender, User receiver) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }
    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getTitle() {
        return title;
    }

    final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @Override
    public String toString() {
        return "Mail: " +
                "\nOd: " + sender.getName() +
                "\nDo: " + receiver.getName() +
                "\nData: " + date.format(CUSTOM_FORMATTER) +
                "\nTytuł: " + title +
                "\nTreść: " + description;
    }
}


