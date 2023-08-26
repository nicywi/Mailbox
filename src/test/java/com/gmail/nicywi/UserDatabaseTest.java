package com.gmail.nicywi;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDatabaseTest {

    @Test
    void testAddUserTestSuccessful(){
        //given
       final UserDatabase userDatabase = new UserDatabase();
        //when
        final boolean userAdded = userDatabase.addUserTest("David", "david@wp.pl", "david123", "haslo123");
        //then
        assertThat(userAdded).isTrue();
    }
    @Test
    void testAddUserTestDuplicated(){
        //given
        final UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUserTest("David", "david@wp.pl", "david123", "haslo123");

        //when
        final boolean userNotAdded = userDatabase.addUserTest("David", "david@wp.pl", "david123", "haslo123");
        //then
        assertThat(userNotAdded).isFalse();
    }

    @Test
    void testLoginTestSuccessful(){
        //given
        final UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUserTest("David", "david@wp.pl", "david123", "haslo123");
        //when
        final User user1 = userDatabase.loginTest("david123", "haslo123");
        //then
        assertThat(user1).isEqualTo(user1);
    }
    @Test
    void testLoginTestisNull(){
        //given
        final UserDatabase userDatabase = new UserDatabase();
        //when
        final User user1 = userDatabase.loginTest("david123", "haslo123");
        //then
        assertThat(user1).isNull();
    }

    @Test
    void testGetUsersIsEmpty(){
        //given
        final UserDatabase userDatabase = new UserDatabase();
        //when
        Map<String, User> users = userDatabase.getUsers();
        //then
        assertThat(users).isEmpty();
    }

    @Test
    void testGetUserNonEmptyList() {
        //given
        final UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUserTest("John", "john@wp.pl", "login123", "haslo123");
        User user1 = new User("John", "john@wp.pl", "login123", "haslo123");
        //when
        Map<String, User> users = userDatabase.getUsers();

        //then
        assertThat(users).isNotNull();
        assertThat(users).containsKey("login123");
        assertThat(users).hasSize(1);
        assertThat(users.get("login123").getName()).isEqualTo("John");
        assertThat(users.get("login123").getPassword()).isEqualTo("haslo123");
        assertThat(users.get("login123").getEmailAddress()).isEqualTo("john@wp.pl");
    }

}
