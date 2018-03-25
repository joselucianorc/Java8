package br.com.joselucianorc.lambdaexpression;

public class UsandoThreadComLambdas {

	public static void main(String[] args) {
		// Executando a thread implementando o m�todo obrigat�rio como classe an�nima.
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Executando um Runnable");
			}
		}).start();

		// Executando a thread utilizando lambda
		new Thread(() -> {
			System.out.println("Executando um Runnable");
		}).start();

		// Executando a thread utilizando lambda e removendo as chaves e o ponto e
		// v�rgula
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
}
