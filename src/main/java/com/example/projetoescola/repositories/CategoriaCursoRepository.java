package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {

    @Autowired
    private EntityManager entityManager;

    public List<CategoriaCurso> obterTodos() {
        return entityManager.createQuery("from CategoriaCurso", CategoriaCurso.class).getResultList();
    }

    @Transactional
    public CategoriaCurso inserir(CategoriaCurso categoriaCurso) {
        categoriaCurso = entityManager.merge(categoriaCurso);
        return categoriaCurso;
    }

    public List<CategoriaCurso> obterPorNome(String nome) {
        String jpql = " select c from CategoriaCurso c where c.nome like :nome";
        TypedQuery<CategoriaCurso> query = entityManager.createQuery(jpql, CategoriaCurso.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional
    public CategoriaCurso atualizar(CategoriaCurso categoriaCurso) {
        categoriaCurso = entityManager.merge(categoriaCurso);
        return categoriaCurso;
    }

    @Transactional
    public void excluir(int id) {
        CategoriaCurso cursoRemover = entityManager.find(CategoriaCurso.class, id);
        entityManager.remove(cursoRemover);
    }
}
