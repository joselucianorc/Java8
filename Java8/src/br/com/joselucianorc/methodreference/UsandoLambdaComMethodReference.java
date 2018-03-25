package br.com.joselucianorc.methodreference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class UsandoLambdaComMethodReference {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();

		palavras.add("José Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("José Lima");
		palavras.add("Anacleto Feitosa");

		// Ordenar por tamanho
		palavras.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});

		// Ordenar por tamanho usando lambda
		palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

		// Ordenar por tamanho usando lambda e otimizando a comparação para que tenha
		// apenas uma instrução
		palavras.sort((String s1, String s2) -> {
			return Integer.compare(s1.length(), s2.length());
		});

		// Ordenar por tamanho usando lambda, otimizando para que tenha apenas uma
		// instrução, sem retorno, sem chaves e sem ponto e vírgula
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()) );
		
		
		// Ordenar por tamanho usando lambda, otimizando para que tenha apenas uma
		// instrução, sem retorno, sem chaves e sem ponto e vírgula sem usar a API
		palavras.sort((String s1, String s2) -> s1.length() - s2.length() );
		

		// Reference Method
		//------------------------------------------------------------------------------------------
		
		//Função recebe uma string e retorna um inteiro
		Function<String, Integer> funcaoAnonima = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		
		// Dada uma string devolve um integer
		Comparator<String> comparador = Comparator.comparing(funcaoAnonima);
		palavras.sort(comparador);
		
		//-------------------------------------------------------------------------------------------
		//Convertendo a função anônima em lambda e otimizando o código
		
		Comparator<String> comparador2 = Comparator.comparing(s -> s.length());
		palavras.sort(comparador);
		
		//-------------------------------------------------------------------------------------------
		// Palavras ordene usando o tamanho da string.
		palavras.sort(Comparator.comparing(s -> s.length())); 
		
		// Otimizando mais ainda - Palavras ordene as strings pelo length
		palavras.sort(Comparator.comparing(String::length));
		
		//-------------------------------------------------------------------------------------------
		// Estas duas funções têm o mesmo efeito
		
		// Significa para esta string que será passada para o método apply invoque o método lenght dela
		Function<String, Integer> funcao1 = String::length;
		// Significa para a string s invoque o método lenght dela
		Function<String, Integer> funcao2 = s -> s.length();
		
		Consumer<String> consumer = s -> System.out.println(s);
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(consumer);
		
		Consumer<String> consumerReferenceMethod = System.out::println;		
		palavras.forEach(consumerReferenceMethod);
		palavras.forEach(System.out::println);
		
		
	}
}
