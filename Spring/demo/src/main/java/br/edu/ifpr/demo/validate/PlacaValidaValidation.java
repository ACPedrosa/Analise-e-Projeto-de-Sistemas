package br.edu.ifpr.demo.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidaValidation implements ConstraintValidator<PlacaValida, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false; // ou true se campo for opcional
        }
        return value.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$");
    }

}