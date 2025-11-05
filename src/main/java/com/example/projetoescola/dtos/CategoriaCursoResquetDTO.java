package com.example.projetoescola.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCursoResquetDTO {
    public Long Id;
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
}
