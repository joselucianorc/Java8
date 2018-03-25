package br.com.joselucianorc.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 113));

		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(System.out::println);
		// Method reference tem limitações

		cursos.forEach(c -> System.out.println(c.getNome()));

		// Quero imprimir todos os cursos que têm mais de 100 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
		
		// Depois de filtrar quero saber quantos alunos tem em cada um desses cursos
		// filter filtra por algum critério
		// map mapeia para outro tipo de stream
		// forEach itera na lista do tipo mapeado
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100) //Não dá para usar Method Reference por causa dessa condição
			.map(c -> c.getAlunos())
			.forEach(total -> System.out.println(total));
		
		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100)
		.mapToInt(Curso::getAlunos)
		.sum();
		
		System.out.println(sum);
		
		//	map, collect, findFirst e findAny
		
	}

}
