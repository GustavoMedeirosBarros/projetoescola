package com.example.projetoescola.models;

import java.sql.Date;
import java.time.LocalDate;

import com.example.projetoescola.validations.SenhaUsuarioValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SenhaUsuarioValidation(message = "Senha e confirmação de senha devem ser iguais")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String confirmaSenha;

    @Column(nullable = false)
    private LocalDate dataDeNascimento;
}
