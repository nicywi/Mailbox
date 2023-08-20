package com.gmail.nicywi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("wybierz opcje");
        System.out.println("1-login");
        System.out.println("2-new user");
        int choose = scanner.nextInt();
        UserDatabase userDatabase = new UserDatabase();

        if (choose == 1) {

            Scanner scanner2 = new Scanner(System.in);

            System.out.println("LOGOWANIE");

            System.out.println("Podaj login: ");
            String login = scanner2.nextLine();
            System.out.println("Podaj hasło: ");
            String password = scanner2.nextLine();
            userDatabase.login(login, password);
        } else if (choose == 2) {
            Scanner scanner3 = new Scanner(System.in);

            System.out.println("NOWY USER");

            System.out.println("Podaj login: ");
            String login = scanner3.nextLine();
            System.out.println("Podaj hasło: ");
            String password = scanner3.nextLine();
            System.out.println("Podaj imie: ");
            String name = scanner3.nextLine();
            System.out.println("Podaj email adres: ");
            String emailaddres = scanner3.nextLine();

            userDatabase.addUser(login, password, name, emailaddres);
        }

        MailService mailService1 = new MailService();

        User user1 = new User("John", "john@gmail.com", "john123", "hasloJohna");
        Inbox inbox1 = new Inbox(user1);
        mailService1.getInboxes().add(inbox1);

        User user2 = new User("Anna", "anna@gmail.com", "anna123", "hasloAnny");
        Inbox inbox2 = new Inbox(user2);
        mailService1.getInboxes().add(inbox2);

        Mail mail1 = new Mail("Wedding invitation", "Hi Anna blabla", LocalDate.now(), user1, user2);
        Mail mail2 = new Mail("Wedding reply", "Hi John blabla", LocalDate.now(), user2, user1);

        mailService1.send(mail1);
        mailService1.send(mail2);
        System.out.println((mailService1.getReceivedEmails(user1)));

        System.out.println("GET SENT TEST");
        System.out.println((mailService1.getSentEmails(user1)));


    }
}