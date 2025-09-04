package com.example.projetoescola;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Disciplina;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.DisciplinaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {
	@Bean
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriacursoRepository,
			@Autowired DisciplinaRepository disciplinaRepository) {
		return args -> {
			Disciplina d1 = disciplinaRepository.disciplina(new Disciplina(null, "ADS"));

			CategoriaCurso c1 = categoriacursoRepository.inserir(
					new CategoriaCurso(null, "Presencial"));

			cursoRepository.salvar(
					new Curso(null, "teste", 2000));
			cursoRepository.salvar(
					new Curso(null, "teste2", 2050));
			List<Curso> listaCursos = cursoRepository.obterTodos();
			listaCursos.forEach(System.out::println);

			listaCursos.forEach(curso -> {
				curso.setCategoriaCurso(c1);
				curso.setDisciplinas(Arrays.asList(d1));
				cursoRepository.salvar(curso);
			});

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
		;
	}

}
