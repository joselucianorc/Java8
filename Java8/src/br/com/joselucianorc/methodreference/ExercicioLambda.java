package br.com.joselucianorc.methodreference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExercicioLambda {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("José Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("José Lima");
		palavras.add("Anacleto Feitosa");


		palavras.sort(Comparator.comparing(s -> s.charAt(0)));
		palavras.forEach(System.out::println);
	}

}
