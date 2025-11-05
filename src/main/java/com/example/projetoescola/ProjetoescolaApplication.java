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
import com.example.projetoescola.models.Professor;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.DisciplinaRepository;
import com.example.projetoescola.repositories.ProfessorRepository;

@SpringBootApplication
public class ProjetoescolaApplication {
	@Bean
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriacursoRepository,
			@Autowired DisciplinaRepository disciplinaRepository,
			@Autowired ProfessorRepository professorRepository) {
		return args -> {
			Disciplina d1 = disciplinaRepository.save(new Disciplina(null, "ADS"));

			CategoriaCurso c1 = categoriacursoRepository.save(
					new CategoriaCurso(null, "Presencial", null));

			cursoRepository.save(
					new Curso(null, "teste", 2000, null, null));
			cursoRepository.save(
					new Curso(null, "teste2", 2050, null, null));
			List<Curso> listaCursos = cursoRepository.findAll();
			listaCursos.forEach(System.out::println);

			listaCursos.forEach(curso -> {
				curso.setCategoriaCurso(c1);
				curso.setDisciplinas(Arrays.asList(d1));
				cursoRepository.save(curso);
			});

			System.out.println("Cursos que começam com 'Jogos'");
			cursoRepository.findByNomeLike("Jogos%").forEach(System.out::println);

			professorRepository.save(new Professor(null, "Gustavo", 2500));
			professorRepository.save(new Professor(null, "Ana", 1800));
			professorRepository.save(new Professor(null, "Maria", 2200));
			professorRepository.save(new Professor(null, "João", 1500));
			professorRepository.save(new Professor(null, "Pedro", 3000));
			professorRepository.save(new Professor(null, "Paulo", 1200));

			System.out.println("Professores com salário maior ou igual a 2000");
			professorRepository.findBySalarioGreaterThanEqual(2000).forEach(System.out::println);

			System.out.println("Professores com salário menor ou igual a 2000");
			professorRepository.findBySalarioLessThanEqual(2000).forEach(System.out::println);

			System.out.println("Professores com nome que contém 'o'");
			professorRepository.findByNomeLike("%o%").forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
		;
	}

}
