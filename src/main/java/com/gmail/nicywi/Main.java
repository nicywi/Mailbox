package com.gmail.nicywi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static User newReceiver() {
        System.out.println("NOWY RECEIVER");
        System.out.println("Podaj imie receivera: ");
        String name = scanner.nextLine();
        System.out.println("Podaj email adres receivera: ");
        String emailaddres = scanner.nextLine();
        return new User(name, emailaddres);
    }
    public static User getUser() {
        //MENU LOGIN VS NEW USER
        System.out.println("wybierz opcje");
        System.out.println("1-login");
        System.out.println("2-new user");
        int choose = scanner.nextInt();
        return (choose == 1) ? login() : newUser();
    }

    public static User findUser() {
        System.out.println("Do kogo chcesz wyslac?");
        scanner.nextLine();
        String name = scanner.nextLine();

        for (User user : userDatabase.getUsers().values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return newReceiver();
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

            switch (choose2) {
                case 1:
                    User receiver = findUser();
                    mailService.send(createMail(user, receiver));
                    break;
                case 2:
                    System.out.println((mailService.getReceivedEmails(user)));
                    break;
                case 3:
                    System.out.println((mailService.getSentEmails(user)));
                    break;
                case 4:
                    System.out.println("Do zobaczenia");
                    return;
                default:
                    System.out.println("Błąd wyboru");
            }
        } while (true);


    }

    public static Mail createMail(User user, User receiver) {
        System.out.println("Podaj tytyl: ");
        String title = scanner.nextLine();
        System.out.println("Podaj treść maila: ");
        String description = scanner.nextLine();
        return new Mail(title, description, LocalDateTime.now(), user, receiver);
    }

    public static void main(String[] args) {
        userDatabase.addUserTest("John", "john@gmail.com", "john123", "hasloJohna");

       // Inbox inbox1 = new Inbox(user1);
        //.getInboxes().add(inbox1);

        //User user2 = new User("Anna", "anna@gmail.com", "anna123", "hasloAnny");
        //Inbox inbox2 = new Inbox(user2);
       // mailService.getInboxes().add(inbox2);

        getMenu(getUser());

    }

}