package br.com.joselucianorc.defaultmethods;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsUsandoComparator {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("José Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("José Lima");
		palavras.add("Anacleto Feitosa");
		
		//Ordenando sem comparator
		Collections.sort(palavras);
		System.out.println(palavras);
		
		//Ordenando usando a ordem natural
		Collections.sort(palavras, Comparator.naturalOrder());
		System.out.println(palavras);
		
		//Ordenando usando a ordem reversa
		Collections.sort(palavras, Comparator.reverseOrder());
		System.out.println(palavras);
		
		//Ordenando por tamanho da string
		Collections.sort(palavras, new ComparadorPorTamanho());
		System.out.println(palavras);
	}
}


