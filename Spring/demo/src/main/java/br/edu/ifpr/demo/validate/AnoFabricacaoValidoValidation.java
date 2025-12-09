package br.edu.ifpr.demo.validate;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnoFabricacaoValidoValidation implements ConstraintValidator<AnoFabricacaoValido, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // ou true se ano puder ser nulo
        }
        int year = LocalDate.now().getYear();
        return value > 1886 && value < year;
    }

}