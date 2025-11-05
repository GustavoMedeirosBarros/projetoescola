package com.example.projetoescola.validations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import com.example.projetoescola.contraints.NomeCursoContraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomeCursoContraint.class)
public @interface NomeCursoValidation {
    String message()

    default "Nome fora do padrão";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
