package com.gmail.nicywi;

import java.time.LocalDate;
import java.util.Scanner;

public class Mail {
    private String title;
    private String description;
    private LocalDate date;
    private User sender;
    private User receiver;

    public Mail(String title, String description, LocalDate date, User sender, User receiver) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Mail() {
    }

    Scanner scanner = new Scanner(System.in);
    public Mail createMail(User user){
        System.out.println("Podaj tytyl: ");
        title = scanner.nextLine();
        System.out.println("Podaj treść maila: ");
        description = scanner.nextLine();
        LocalDate date1 = null;
        return new Mail(title, description, date1, user, receiver);
    }
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    @Override
    public String toString() {
        return "Mail{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", sender=" + sender.getName() +
                ", receiver=" + receiver.getName() +
                '}';
    }
}


