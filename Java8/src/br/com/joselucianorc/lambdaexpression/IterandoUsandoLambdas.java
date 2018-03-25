package br.com.joselucianorc.lambdaexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class IterandoUsandoLambdas {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();

		palavras.add("Jos� Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("Jos� Lima");
		palavras.add("Anacleto Feitosa");

		// Ordenar por tamanho
		palavras.sort(new CompararPorTamanho());

		// -------------------------------------------------------------------------
		// class ImprimirConsumer implements Consumer<String> {
		//		@Override
		//		public void accept(String t) {
		//			System.out.println(t);
		//		}
		//	}
		
		// Iterar na lista com Consumer em classe separada
		Consumer<String> consumer = new ImprimirConsumer();
		palavras.forEach(consumer);

		// -------------------------------------------------------------------------
		// Iterar na lista com Consumer em classe an�nima atribu�da a vari�vel
		Consumer<String> consumerAnonima = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		// Iterar na lista com Consumer em classe separada
		palavras.forEach(consumerAnonima);

		// -------------------------------------------------------------------------

		// Iterar na lista com Consumer em classe an�nima passada como par�metro
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});

		// Iterar na lista com Lambda removendo a instancia��o da classe an�nima e
		// partindo dos par�metros do m�todo, n�o precisa dizer que vai trabalhar com um
		// Consumer e ele tem um m�todo accept. Obt�m o mesmo resultado com c�digo
		// enxuto
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		// Iterar na lista com Lambda
		// Quando ecebe apenas um par�metro n�o � obrigado ter o tipo
		palavras.forEach((s) -> {
			System.out.println(s);
		});

		// Iterar na lista com Lambda
		// N�o � obrigado ter os par�nteses quando se tem apenas um par�metro
		palavras.forEach(s -> {
			System.out.println(s);
		});

		// Iterar na lista com Lambda
		// Se tiver apenas uma instru��o para execu��o n�o � obrigado ter as chaves nem
		// o ponto e v�rgula.
		palavras.forEach(s -> System.out.println(s));
		
		
		//S� para fixar, essas duas linhas abaixo
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
		
		//S�o iguais a 
		palavras.forEach(s -> System.out.println(s));
		
		//Para funcionar precisa de uma interface funcional, ou seja com um apenas um m�todo
	}
}

class ImprimirConsumer implements Consumer<String> {
	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}

class CompararPorTamanho implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}
