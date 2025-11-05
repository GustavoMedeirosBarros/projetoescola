package com.example.projetoescola.dtos;

import com.example.projetoescola.validations.NomeCursoValidation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequestDTO {
    public Long Id;

    @NotEmpty(message = "Nome é obrigatório")
    @NomeCursoValidation(message = "Nome tem que estar no padrão")
    private String nome;

    @Min(value = 0, message = "Carga horária deve ser maior que zero")
    @Max(value = 4000, message = "Carga horária deve ser menor que 5000")
    private Integer cargaHoraria;
    private Integer idCategoriaCurso;
}
