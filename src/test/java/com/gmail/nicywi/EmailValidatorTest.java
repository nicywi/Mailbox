package com.gmail.nicywi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {

    @Test
    void testisValidEmail(){
        //given
        final EmailValidator emailValidator = new EmailValidator();
        //when
        final boolean emailValid = emailValidator.isValidEmail("nikola@wp.pl");
        //then
        assertThat(emailValid).isTrue();
    }

    @Test
    void testisNotValidEmail(){
        //given
        final EmailValidator emailValidator = new EmailValidator();
        //when
        final boolean emailNotValid = emailValidator.isValidEmail("nikolawp.pl");
        //then
        assertThat(emailNotValid).isFalse();
    }
}
