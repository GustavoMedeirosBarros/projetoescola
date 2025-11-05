package com.example.projetoescola.contraints;

import com.example.projetoescola.validations.NomeCursoValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NomeCursoContraint implements ConstraintValidator<NomeCursoValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (!value.matches("[a-z]{5}[0-9]{2}")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
