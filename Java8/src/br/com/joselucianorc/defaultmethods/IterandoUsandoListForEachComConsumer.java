package br.com.joselucianorc.defaultmethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class IterandoUsandoListForEachComConsumer {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("José Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("José Lima");
		palavras.add("Anacleto Feitosa");

		//Ordenar por tamanho
		palavras.sort(new CompararPorTamanho());
		
		//Iterar na lista
		Consumer<String> consumer = new ImprimirConsumer();
		palavras.forEach(consumer);
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

