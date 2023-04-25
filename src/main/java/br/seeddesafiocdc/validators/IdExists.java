package br.seeddesafiocdc.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = IdExistsValidator.class)
@Documented
public @interface IdExists {

    String message() default "{id.exists}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> domainClass();
}
