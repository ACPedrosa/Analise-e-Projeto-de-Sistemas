package br.edu.ifpr.demo.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = CHNValidaValidation.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CNHValida {
    String message() default "CNH Inválida. Ela deve conter 11 caracteres numéricos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
