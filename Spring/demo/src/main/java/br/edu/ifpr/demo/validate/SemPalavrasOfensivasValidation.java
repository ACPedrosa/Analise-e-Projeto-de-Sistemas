package br.edu.ifpr.demo.validate;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SemPalavrasOfensivasValidation implements ConstraintValidator<SemPalavrasOfensivas, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true; // ou false, dependendo do seu caso
        }

        List<String> palavrasProibidas = Arrays.asList(
                "burro", "idiota", "lixo", "otário", "imbecil", "estúpido",
                "vagabundo", "desgraçado", "miserável", "porco", "demente",
                "demêcia", "abestado", "puto");

        return palavrasProibidas.stream().noneMatch(p -> value.toLowerCase().contains(p));
    }

}