package br.com.joselucianorc.lambdaexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class UsandoLambdaNoComparator {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();

		palavras.add("Jos� Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("Jos� Lima");
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

		// Ordenar por tamanho usando lambda e otimizando a compara��o para que tenha
		// apenas uma instru��o
		palavras.sort((String s1, String s2) -> {
			return Integer.compare(s1.length(), s2.length());
		});

		// Ordenar por tamanho usando lambda, otimizando para que tenha apenas uma
		// instru��o, sem retorno, sem chaves e sem ponto e v�rgula
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()) );
		
		
		// Ordenar por tamanho usando lambda, otimizando para que tenha apenas uma
		// instru��o, sem retorno, sem chaves e sem ponto e v�rgula sem usar a API
		palavras.sort((String s1, String s2) -> s1.length() - s2.length() );
		
	}
}
