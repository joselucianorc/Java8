package br.com.joselucianorc.defaultmethods;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenaStringsUsandoCollectionsSort {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("José Luciano");
		palavras.add("Vania Rodrigues");
		palavras.add("Janayna Rodrigues");
		palavras.add("José Lima");
		palavras.add("Anacleto Feitosa");
		
		Collections.sort(palavras);
		System.out.println(palavras);
	}
}


