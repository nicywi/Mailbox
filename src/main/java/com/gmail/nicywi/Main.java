package com.gmail.nicywi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("wybierz opcje");
        System.out.println("1-login");
        System.out.println("2-new user");
        int choose = scanner.nextInt();
        UserDatabase userDatabase = new UserDatabase();

        if (choose == 1) 

            }


            MailService mailService1 = new MailService();

            User user1 = new User("John", "john@gmail.com");
            Inbox inbox1 = new Inbox(user1);
            mailService1.getInboxes().add(inbox1);

            User user2 = new User("Anna", "anna@gmail.com");
            Inbox inbox2 = new Inbox(user2);
            mailService1.getInboxes().add(inbox2);

            Mail mail1 = new Mail("Wedding invitation", "Hi Anna blabla", LocalDate.now(), user1, user2);
            Mail mail2 = new Mail("Wedding reply", "Hi John blabla", LocalDate.now(), user2, user1);


        }
    }