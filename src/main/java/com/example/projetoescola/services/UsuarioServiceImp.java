package com.example.projetoescola.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.RegrasNegocioException;
import com.example.projetoescola.dtos.UsuarioDTO;
import com.example.projetoescola.dtos.UsuarioRequestDTO;
import com.example.projetoescola.models.Usuario;
import com.example.projetoescola.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void salvar(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setConfirmaSenha(usuarioRequestDTO.getConfirmaSenha());
        usuario.setDataDeNascimento(usuarioRequestDTO.getDataDeNascimento());
        usuarioRepository.save(usuario);
    }

    @Override
    public void remover(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegrasNegocioException("Código usuario não encontrado."));
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setConfirmaSenha(dto.getConfirmaSenha());
        usuario.setDataDeNascimento(dto.getDataDeNascimento());
        usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO obterPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegrasNegocioException("Código usuario não encontrado."));
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .dataDeNascimento(usuario.getDataDeNascimento())
                .build();
    }

    @Override
    public List<UsuarioDTO> obterTodos() {
        return usuarioRepository.findAll().stream().map((Usuario u) -> {
            return UsuarioDTO.builder()
                    .id(u.getId())
                    .nome(u.getNome())
                    .email(u.getEmail())
                    .dataDeNascimento(u.getDataDeNascimento())
                    .build();
        }).collect(Collectors.toList());

    }
}
