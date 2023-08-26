package com.gmail.nicywi;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MailServiceTest {

    @Test
    void testSend(){
        //given
        final MailService mailService = new MailService();
        //when
        Mail mail = new Mail("Tytuł", "Treść", LocalDateTime.now(), new User("John", "john@wp.pl", "login123", "haslo123"), new User("David", "david@gmail.com", "david1234", "haslo1234"));
        mailService.send(mail);
        //then
        assertThat(mailService.getMails()).containsExactlyInAnyOrder(mail);
    }
    @Test
    void testSendMailsIsEmpty(){
        //given
        final MailService mailService = new MailService();
        //then
        assertThat(mailService.getMails()).isEmpty();
    }
    @Test
    void testGetReceivedEmailsSuccessful(){
        //given
        final MailService mailService = new MailService();
        User user1 = new User("John", "john@wp.pl", "login123", "haslo123");
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        Mail mail = new Mail("Tytuł", "Treść", LocalDateTime.now(), user1, user2);
        //when
        mailService.send(mail);
        List<Mail> receivedMailsUser2 = mailService.getReceivedEmails(user2);
        //then
        assertThat(receivedMailsUser2).containsExactlyInAnyOrder(mail);
    }
    @Test
    void testGetReceivedEmailsEmpty(){
        //given
        final MailService mailService = new MailService();
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        //when
        List<Mail> receivedMailsUser2 = mailService.getReceivedEmails(user2);
        //then
        assertThat(receivedMailsUser2).isEmpty();
    }

    @Test
    void testGetSentEmailsSuccessful(){
        //given
        final MailService mailService = new MailService();
        User user1 = new User("John", "john@wp.pl", "login123", "haslo123");
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        Mail mail = new Mail("Tytuł", "Treść", LocalDateTime.now(), user1, user2);
        //when
        mailService.send(mail);
        List<Mail> sentMailsUser2 = mailService.getSentEmails(user1);
        //then
        assertThat(sentMailsUser2).containsExactlyInAnyOrder(mail);
    }
    @Test
    void testGetSentEmailsEmpty(){
        //given
        final MailService mailService = new MailService();
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        //when
        List<Mail> sentMailsUser2 = mailService.getSentEmails(user2);
        //then
        assertThat(sentMailsUser2).isEmpty();
    }

    @Test
    void testDeleteReceivedEmailsSuccessful(){
        //given
        final MailService mailService = new MailService();
        User user1 = new User("John", "john@wp.pl", "login123", "haslo123");
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        Mail mail = new Mail("Tytuł", "Treść", LocalDateTime.now(), user1, user2);
        //when
        mailService.send(mail);
        mailService.deleteReceivedEmails(user2);
        //then
        assertThat(mailService.getReceivedEmails(user2)).isEmpty();
    }


    @Test
    void testDeleteSentEmailsSuccessful(){
        //given
        final MailService mailService = new MailService();
        User user1 = new User("John", "john@wp.pl", "login123", "haslo123");
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        Mail mail = new Mail("Tytuł", "Treść", LocalDateTime.now(), user1, user2);
        //when
        mailService.send(mail);
        mailService.deleteSentEmails(user1);
        //then
        assertThat(mailService.getSentEmails(user1)).isEmpty();
    }

    @Test
    void testGetMailsIsEmpty(){
        //given
        final MailService mailService = new MailService();
        //when
        List<Mail> mails = mailService.getMails();
        //then
        assertThat(mails).isEmpty();
    }

    @Test
    void testGetMailsNonEmptyList() {
        //given
        final MailService mailService = new MailService();
        User user1 = new User("John", "john@wp.pl", "login123", "haslo123");
        User user2 = new User("David", "david@gmail.com", "david1234", "haslo1234");
        Mail mail = new Mail("Tytuł", "Treść", LocalDateTime.now(), user1, user2);

        //when
        mailService.send(mail);
        List<Mail> mails = mailService.getMails();

        //then
        assertThat(mails).containsExactlyInAnyOrder(mail);
    }


}
