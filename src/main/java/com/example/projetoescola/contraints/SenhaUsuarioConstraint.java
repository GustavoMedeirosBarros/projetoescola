package com.example.projetoescola.contraints;

import com.example.projetoescola.models.Usuario;
import com.example.projetoescola.validations.SenhaUsuarioValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhaUsuarioConstraint implements ConstraintValidator<SenhaUsuarioValidation, Usuario> {
    @Override
    public boolean isValid(Usuario usuario, ConstraintValidatorContext context) {
        if (usuario == null) {
            return true; // evita erro de NullPointer
        }

        String senha = usuario.getSenha();
        String confirmarSenha = usuario.getConfirmaSenha();

        if (senha == null || confirmarSenha == null) {
            return true; // deixa outras validações tratarem nulos
        }

        boolean iguais = senha.equals(confirmarSenha);

        if (!iguais) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "A senha e a confirmação de senha devem ser iguais.").addPropertyNode("confirmarSenha")
                    .addConstraintViolation();
        }

        return iguais;
    }
}
