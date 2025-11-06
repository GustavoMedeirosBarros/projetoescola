package com.example.projetoescola.dtos;

import java.time.LocalDate;

import com.example.projetoescola.validations.SenhaUsuarioValidation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRequestDTO {
    @NotEmpty(message = "Nome é obrigatório")
    @Min(value = 3, message = "Nome deve ter no mínimo 3 caracteres")
    @Max(value = 50, message = "Nome deve ter no máximo 50 caracteres")
    private String nome;

    @NotEmpty(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotEmpty(message = "Senha é obrigatória")
    @Min(value = 8, message = "Senha deve ter no mínimo 8 caracteres")
    private String senha;

    @NotEmpty(message = "Confirmação de senha é obrigatória")
    private String confirmaSenha;

    @Past(message = "Data de nascimento deve ser uma data passada")
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataDeNascimento;
}
