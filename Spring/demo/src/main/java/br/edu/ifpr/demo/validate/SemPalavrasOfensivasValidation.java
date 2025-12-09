package br.edu.ifpr.demo.validate;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SemPalavrasOfensivasValidation implements ConstraintValidator<SemPalavrasOfensivas, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> palavrasProibidas = Arrays.asList(
                "idiota",
                "chato",
                "besta",
                "estranho",
                "suspeito",
                "bosta"
                );

        return (palavrasProibidas.contains(value));
    }

}
