package br.com.joselucianorc.lambdaexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class IterandoUsandoLambdas {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();

		palavras.add("José Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("José Lima");
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
		// Iterar na lista com Consumer em classe anônima atribuída a variável
		Consumer<String> consumerAnonima = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		// Iterar na lista com Consumer em classe separada
		palavras.forEach(consumerAnonima);

		// -------------------------------------------------------------------------

		// Iterar na lista com Consumer em classe anônima passada como parâmetro
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});

		// Iterar na lista com Lambda removendo a instanciação da classe anônima e
		// partindo dos parâmetros do método, não precisa dizer que vai trabalhar com um
		// Consumer e ele tem um método accept. Obtém o mesmo resultado com código
		// enxuto
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		// Iterar na lista com Lambda
		// Quando ecebe apenas um parâmetro não é obrigado ter o tipo
		palavras.forEach((s) -> {
			System.out.println(s);
		});

		// Iterar na lista com Lambda
		// Não é obrigado ter os parênteses quando se tem apenas um parâmetro
		palavras.forEach(s -> {
			System.out.println(s);
		});

		// Iterar na lista com Lambda
		// Se tiver apenas uma instrução para execução não é obrigado ter as chaves nem
		// o ponto e vírgula.
		palavras.forEach(s -> System.out.println(s));
		
		
		//Só para fixar, essas duas linhas abaixo
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
		
		//São iguais a 
		palavras.forEach(s -> System.out.println(s));
		
		//Para funcionar precisa de uma interface funcional, ou seja com um apenas um método
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
