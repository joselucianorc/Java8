package br.com.joselucianorc.defaultmethods;
import java.util.function.Consumer;

public class ImprimeNaLinhaConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	
}