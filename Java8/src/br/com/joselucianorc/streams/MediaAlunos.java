package br.com.joselucianorc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class MediaAlunos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 113));
		
		OptionalDouble average = cursos.stream().mapToInt(c -> c.getAlunos()).average();

	}

}
