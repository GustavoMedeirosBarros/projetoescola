package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dtos.CategoriaCursoDTO;
import com.example.projetoescola.dtos.CategoriaCursoResquetDTO;

public interface CategoriaCursoImp {
    void salvar(CategoriaCursoDTO categoriaCursoDTO);

    void remover(Long id);

    void editar(Long id, CategoriaCursoResquetDTO dto);

    CategoriaCursoDTO obterPorId(Long id);

    List<CategoriaCursoDTO> obterTodos();
}
