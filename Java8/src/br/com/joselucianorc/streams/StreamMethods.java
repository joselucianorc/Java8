package br.com.joselucianorc.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMethods {

	private String nome;
	private int alunos;

	public StreamMethods(String nome, int alunos) {
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

		//	map, collect, findFirst e findAny
		Optional<Curso> optionalCurso = cursos.stream().filter( c -> c.getAlunos() >= 100 ).findAny();
		
		//Curso curso = optionalCurso.orElse(null);
		//System.out.println(curso.getNome());
		// Teríamos um problema tanto com o orElse ou o get do optionalCurso
		
		optionalCurso.ifPresent(c -> System.out.print(c.getNome()));
		
		// IF PRESENT
		//Reescrevendo e explicando
		cursos.stream() // Cursos me dê o fluxo de todos os seus cursos
			.filter( c -> c.getAlunos() >= 100 ) // Filtre quem tem mais de 100
			.findAny() // Encontre um deles
			.ifPresent(c -> System.out.print(c.getNome())); // Se você encontrou um deles faça isso, se não encontrou não faça nada
		
		//AVERAGE
		 OptionalDouble sum = cursos.stream().filter(c -> c.getAlunos() >= 100) //OptionalDouble previne contra nullpointer
		.mapToInt(Curso::getAlunos)
		.average();
		

		//GUARDAR FILTER DENTRO DA COLLECTION ORIGINAL
		// É através dos coletores que conseguimos voltar de um stream a uma collection
		List<Curso> collect = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
		System.out.println(collect);
		
		//Manipulando Stream para voltar um Mapa
		Map<String, Integer> map = cursos.stream().filter( c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		System.out.println(map);
		
		//Manipulando Stream para voltar um Mapa já concatenando o forEach
		cursos.stream().filter( c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));
		
		//Manipulando Stream em paralelo usará spliterator e outros recursos avançados para paralelizar o processamento
		//Em operações com poucos elementos e tarefas simples não compensa usar.
		//Manipulando Stream para voltar um Mapa já concatenando o forEach
		cursos.parallelStream().filter( c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));
	}

}
