package br.seeddesafiocdc.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@ConstraintComposition(CompositionType.OR)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@CPF
@CNPJ
public @interface Documento {

    String message() default "{documento.invalido}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
