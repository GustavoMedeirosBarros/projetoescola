package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.projetoescola.dtos.UsuarioDTO;
import com.example.projetoescola.dtos.UsuarioRequestDTO;
import com.example.projetoescola.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    public void criarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.salvar(usuarioRequestDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obterUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obterPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        usuarioService.remover(id);
    }

    @PutMapping("{id}")
    public void editar(@Valid @PathVariable Long id, @RequestBody UsuarioRequestDTO dto) {
        usuarioService.editar(id, dto);
    }

    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        return usuarioService.obterTodos();
    }

}
