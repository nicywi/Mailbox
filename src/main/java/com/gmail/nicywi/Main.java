package com.gmail.nicywi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final UserDatabase userDatabase = new UserDatabase();
    private static final MailService mailService = new MailService();
    public static User login() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("LOGOWANIE");
        System.out.println("Podaj login: ");
        String login = scanner2.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scanner2.nextLine();
        return userDatabase.loginTest(login, password);
    }

    public static User newUser(){
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

        boolean addUserSuccess = userDatabase.addUserTest(login, password, name, emailaddres);

        if(addUserSuccess){
            System.out.println("Dodawanie uzytkownika przegieglo pomyslnie");
        }else{
            System.out.println("Dodawanie nie powioslo sie");
        }
        return new User(name, emailaddres, login, password);
    }

    public static void main(String[] args) {

        User user1 = new User("John", "john@gmail.com", "john123", "hasloJohna");
        userDatabase.addUserTest("John", "john@gmail.com", "john123", "hasloJohna");

        Inbox inbox1 = new Inbox(user1);
        mailService.getInboxes().add(inbox1);

        User user2 = new User("Anna", "anna@gmail.com", "anna123", "hasloAnny");
        Inbox inbox2 = new Inbox(user2);
        mailService.getInboxes().add(inbox2);

        Mail mail1 = new Mail("Wedding invitation", "Hi Anna blabla", LocalDate.now(), user1, user2);
        Mail mail2 = new Mail("Wedding reply", "Hi John blabla", LocalDate.now(), user2, user1);


        //MENU LOGIN VS NEW USER
        Scanner scanner = new Scanner(System.in);
        System.out.println("wybierz opcje");
        System.out.println("1-login");
        System.out.println("2-new user");
        int choose = scanner.nextInt();

        if (choose == 1) {
            login();
        } else if (choose == 2) {
           newUser();
        }

        //TEST SEND EMAILS
        mailService.send(mail1);
        mailService.send(mail2);

        //TEST GETRECEIVED EMAILS METHOD & GETSENTEMAILS METHOD
        System.out.println((mailService.getReceivedEmails(user1)));

        System.out.println("GET SENT TEST");
        System.out.println((mailService.getSentEmails(user1)));

    }
}