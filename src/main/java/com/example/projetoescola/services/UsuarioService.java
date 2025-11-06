package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dtos.UsuarioDTO;
import com.example.projetoescola.dtos.UsuarioRequestDTO;

public interface UsuarioService {
    void salvar(UsuarioRequestDTO usuarioRequestDTO);

    void remover(Long id);

    void editar(Long id, UsuarioRequestDTO dto);

    UsuarioDTO obterPorId(Long id);

    List<UsuarioDTO> obterTodos();
}
