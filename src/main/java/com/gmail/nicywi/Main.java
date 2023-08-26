package com.gmail.nicywi;

import java.time.LocalDateTime;
import java.util.Scanner;
public class Main {

    private static final UserDatabase userDatabase = new UserDatabase();
    private static final Scanner scanner = new Scanner(System.in);
    private static final MailService mailService = new MailService();
    private static final EmailValidator emailValidator = new EmailValidator();

    public static User login() {
        System.out.println("LOGOWANIE");
        scanner.nextLine();
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();
        //if null i dodajemy newuser
        return (userDatabase.loginTest(login, password) == null) ? newUser() : userDatabase.loginTest(login, password);
    }

    public static User newUser() {
        System.out.println("TWORZENIE NOWEGO UŻYTKOWNIKA");
        scanner.nextLine();
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj email adres: ");
        String emailaddres = scanner.nextLine();

        while (!emailValidator.isValidEmail(emailaddres)) {
            System.out.println(emailaddres + " jest niepoprawnym adresem e-mail.");
            System.out.println("Podaj inny adres email: ");
            emailaddres = scanner.nextLine();
        }
            System.out.println(emailaddres + " jest poprawnym adresem e-mail.");

        boolean addUserSuccess = userDatabase.addUserTest(login, password, name, emailaddres);

        if (addUserSuccess) {
            System.out.println("Dodawanie uzytkownika przegieglo pomyslnie");
        } else {
            System.out.println("Dodawanie nie powioslo sie");
        }
        return new User(name, emailaddres, login, password);
    }

    public static User newReceiver() {
        System.out.println("NOWY ODBIORCA");
        System.out.println("Podaj imie odbiorcy: ");
        String name = scanner.nextLine();
        System.out.println("Podaj adres email odbiorcy: ");
        String emailaddres = scanner.nextLine();

        while (!emailValidator.isValidEmail(emailaddres)) {
            System.out.println(emailaddres + " jest niepoprawnym adresem e-mail.");
            System.out.println("Podaj adres email: ");
            emailaddres = scanner.nextLine();
        }
        System.out.println(emailaddres + " jest poprawnym adresem e-mail.");
        System.out.println("Podaj username odbiorcy: ");
        String login = scanner.nextLine();
        return new User(name, emailaddres, login);
    }

    public static User getUser() {
        //MENU LOGIN VS NEW USER
        System.out.println("Wybierz opcje: ");
        System.out.println("1-login");
        System.out.println("2-new user");
        int choose = scanner.nextInt();
        return (choose == 1) ? login() : newUser();
    }

    public static User findUser() {
        System.out.println("Do kogo chcesz wysłać maila?");
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
            System.out.println("Wybierz opcje: ");
            System.out.println("1-Wyślij maila");
            System.out.println("2-Wyświetl otrzymane maile");
            System.out.println("3-Wyświetl wysłane maile");
            System.out.println("4-Usuń wszystkie otrzymane maile");
            System.out.println("5-Usuń wszystkie wysłane maile");
            System.out.println("6-Wyjdź ze skrzynki");
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
                    mailService.deleteReceivedEmails(user);
                    System.out.println("Maile zostały pomyślnie usunięte.");
                    break;
                case 5:
                    mailService.deleteSentEmails(user);
                    System.out.println("Maile zostały pomyślnie usunięte.");
                    break;
                case 6:
                    System.out.println("Do zobaczenia");
                    return;
                default:
                    System.out.println("Błąd wyboru");
            }
        } while (true);


    }

    public static Mail createMail(User user, User receiver) {
        System.out.println("Podaj tytył maila: ");
        String title = scanner.nextLine();
        System.out.println("Podaj treść maila: ");
        String description = scanner.nextLine();
        return new Mail(title, description, LocalDateTime.now(), user, receiver);
    }

    public static void main(String[] args) {
        User user = new User("John", "john@gmail.com", "john123", "hasloJohna");
        String login = "john123";
        userDatabase.getUsers().put(login, user);

        // Inbox inbox1 = new Inbox(user1);
        //.getInboxes().add(inbox1);

        User user2 = new User("Anna", "anna@gmail.com", "anna123", "hasloAnny");
        //Inbox inbox2 = new Inbox(user2);
        // mailService.getInboxes().add(inbox2);

        Mail mail = new Mail("Tytuł maila", "Treść maila", LocalDateTime.now(), user2, new User("John", "john@gmail.com", "john123", "hasloJohna"));
        mailService.send(mail);

        getMenu(getUser());

    }

}