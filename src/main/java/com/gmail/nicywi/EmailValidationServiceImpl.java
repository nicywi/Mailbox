package com.gmail.nicywi;

public class EmailValidationServiceImpl implements EmailValidationService{
    private final EmailValidator emailValidator;

    public EmailValidationServiceImpl(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    @Override
    public boolean isValidEmail(String email) {
        return emailValidator.isValidEmail(email);
    }
}
