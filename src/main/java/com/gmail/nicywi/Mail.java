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

    public Mail() {
    }

    Scanner scanner = new Scanner(System.in);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @Override
    public String toString() {
        return "Mail{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date.format(CUSTOM_FORMATTER) +
                ", sender=" + sender.getName() +
                ", receiver=" + receiver.getName() +
                '}';
    }
}


