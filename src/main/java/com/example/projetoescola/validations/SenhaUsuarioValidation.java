package com.example.projetoescola.validations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import com.example.projetoescola.contraints.SenhaUsuarioConstraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = SenhaUsuarioConstraint.class)
@Target(ElementType.TYPE) // usada a nível de classe
@Retention(RetentionPolicy.RUNTIME)
public @interface SenhaUsuarioValidation {
    String message() default "As senhas devem ser iguais.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
