package com.gmail.nicywi;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {
        private final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
        private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
        public boolean isValidEmail(String email) {
            Matcher matcher = EMAIL_PATTERN.matcher(email);
            return matcher.matches();
        }
}
