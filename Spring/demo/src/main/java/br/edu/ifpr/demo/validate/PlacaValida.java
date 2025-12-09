package br.edu.ifpr.demo.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Constraint(validatedBy = PlacaValidaValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaValida {
    String message() default "Placa inválida. Utilize o padrão Mercosul";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
