// package com.example.projetoescola.services;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.projetoescola.repositories.CategoriaCursoRepository;
// import com.example.projetoescola.models.CategoriaCurso;

// @Service
// // public class CategoriaCursoServiceImp implements CategoriaCursoImp {

// // private CategoriaCursoRepository categoriaCursoRepository;

// // public CategoriaCursoServiceImp(CategoriaCursoRepository
// categoriaCursoRepository) {
// // this.categoriaCursoRepository = categoriaCursoRepository;
// // }

// // @Override
// // public void salvar(String nome) {
// // CategoriaCurso categoria = new CategoriaCurso();
// // categoria.setNome(nome);
// // categoriaCursoRepository.save(categoria);
// // }

// // @Override
// // public CategoriaCurso remover(Integer id) {
// // return categoriaCursoRepository.findById(id).map(categoria ->
// CategoriaCurso.builder()
// // .id(categoria.getId())
// // .nome(categoria.getNome())
// // .build())
// // .orElseThrow(() -> new RuntimeException("Categoria de curso nao
// encontrada"));
// // }

// // @Override
// // public void editar(Integer id, String nome) {
// // CategoriaCurso categoria = categoriaCursoRepository.findById(id)
// // .orElseThrow(() -> new RuntimeException("Categoria de curso nao
// encontrada"));
// // categoria.setNome(nome);
// // categoriaCursoRepository.save(categoria);
// // }

// // @Override
// // public CategoriaCurso obterPorId(Integer id) {
// // return categoriaCursoRepository.findById(id)
// // .orElseThrow(() -> new RuntimeException("Categoria de curso nao
// encontrada"));
// // }

// // @Override
// // public List<CategoriaCurso> obterTodos() {
// // return categoriaCursoRepository.findAll();
// // }

// }
