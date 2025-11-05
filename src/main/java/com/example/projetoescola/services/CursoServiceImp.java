package com.example.projetoescola.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.CategoriaCursoDTO;
import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.RegrasNegocioException;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@Service
public class CursoServiceImp implements CursoService {
    private CursoRepository cursoRepository;
    private CategoriaCursoRepository categoriaCursoRepository;

    public CursoServiceImp(CursoRepository cursoRepository, CategoriaCursoRepository categoriaCursoRepository) {
        this.cursoRepository = cursoRepository;
        this.categoriaCursoRepository = categoriaCursoRepository;
    }

    @Override
    public void salvar(CursoRequestDTO cursoRequestDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(cursoRequestDTO.getIdCategoriaCurso())
                .orElseThrow(() -> new RegrasNegocioException("Categoria de curso nao encontrada"));
        Curso curso = new Curso();
        curso.setNome(cursoRequestDTO.getNome());
        curso.setCargaHoraria(cursoRequestDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);
        cursoRepository.save(curso);
    }

    @Override
    public CursoDTO obterPorId(Long id) {
        return cursoRepository.findById(id).map(curso -> CursoDTO.builder()
                .id(curso.getId())
                .nome(curso.getNome())
                .cargaHoraria(curso.getCargaHoraria())
                .categoriaCurso(CategoriaCursoDTO.builder()
                        .id(curso.getCategoriaCurso().getId())
                        .nome(curso.getCategoriaCurso().getNome())
                        .build())
                .build()).orElseThrow(() -> new RegrasNegocioException("Curso nao encontrado"));
    }

    @Override
    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, CursoRequestDTO dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegrasNegocioException("Código curso não encontrado."));
        CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(dto.getIdCategoriaCurso())
                .orElseThrow(() -> new RegrasNegocioException("Categoria não encontrado."));
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        cursoRepository.save(curso);
    }

    @Override
    public List<CursoDTO> obterTodos() {
        return cursoRepository.findAll().stream().map((Curso c) -> {
            return CursoDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoriaCurso(CategoriaCursoDTO.builder()
                            .id(c.getCategoriaCurso().getId())
                            .nome(c.getCategoriaCurso().getNome())
                            .build())
                    .build();
        }).collect(Collectors.toList());
    }
}
