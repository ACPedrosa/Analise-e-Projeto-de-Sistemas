package br.edu.ifpr.demo.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CHNValidaValidation implements ConstraintValidator<CNHValida, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("\\d{11}");
    }

}