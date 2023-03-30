package com.lovecalculator.SpringWebPractice.error;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("demadegu@gmail.com");
    }
}
