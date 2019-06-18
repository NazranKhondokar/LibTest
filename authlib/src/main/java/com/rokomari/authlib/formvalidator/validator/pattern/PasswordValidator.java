package com.rokomari.authlib.formvalidator.validator.pattern;

public class PasswordValidator extends PatternValidator {

    public PasswordValidator(String errorMessage) {

        // Minimum eight characters, at least one letter and one number
        super(errorMessage, "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
