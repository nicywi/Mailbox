package com.gmail.nicywi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final UserDatabase userDatabase = new UserDatabase();
    private static final Scanner scanner = new Scanner(System.in);
    private static final MailService mailService = new MailService();

    public static User login() {
        System.out.println("LOGOWANIE");
        scanner.nextLine();
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();
        return userDatabase.loginTest(login, password);
    }

    public static User newUser() {
        System.out.println("NOWY USER");
        scanner.nextLine();
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();
        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();
        System.out.println("Podaj email adres: ");
        String emailaddres = scanner.nextLine();

        boolean addUserSuccess = userDatabase.addUserTest(login, password, name, emailaddres);

        if (addUserSuccess) {
            System.out.println("Dodawanie uzytkownika przegieglo pomyslnie");
        } else {
            System.out.println("Dodawanie nie powioslo sie");
        }
        return new User(name, emailaddres, login, password);
    }

    public static User getUser() {
        //MENU LOGIN VS NEW USER
        System.out.println("wybierz opcje");
        System.out.println("1-login");
        System.out.println("2-new user");
        int choose = scanner.nextInt();
        return (choose == 1) ? login() : newUser();
    }

    public static void getMenu(User user) {
        do {
            System.out.println(" ");
            System.out.println("Wybierz opcje");
            System.out.println("1-Wyślij maila");
            System.out.println("2-Wyświetl otrzymane maile");
            System.out.println("3-Wyświetl wysłane maile");
            System.out.println("4-Wyjdź ze skrzynki");
            int choose2 = scanner.nextInt();

            Mail mail = new Mail();
            switch (choose2) {
                case 1:
                    mailService.send(mail.createMail(user));
//                    mailService.send(mail2);
                    //mail.createMail();
                    break;
                case 2:
//                    System.out.println((mailService.getReceivedEmails(user1)));
                    break;
                case 3:
//                    System.out.println("GET SENT TEST");
//                    System.out.println((mailService.getSentEmails(user1)));
                    break;
                case 4:
                    System.out.println("Do zobaczenia");
                    return;
                default:
                    System.out.println("Błąd wyboru");
            }
        } while (true);


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

        //mailService.send(mail1);
        //mailService.send(mail2);

        getMenu(getUser());
    }

}