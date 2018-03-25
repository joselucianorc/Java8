package br.com.joselucianorc.dateapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {

		//O que a gente mais utiliza
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Obtenho uma data
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		System.out.println(olimpiadasRio);
		
		//Pego uma data e pego outra data e obtenho a diferença
		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);
		
		Period periodo = Period.between(hoje, olimpiadasRio);
		System.out.println(periodo);
		
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = proximasOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		
		//Trabalhando com Hora minuto e segundo
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHora));
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
		//Pego uma data e somo valores
		
		LocalDate dataEspecifica1 = LocalDate.of(2000, 10, 10);
		System.out.println(dataEspecifica1);
		
		LocalDate dataEspecifica2 = LocalDate.of(2000, Month.OCTOBER, 10);
		System.out.println(dataEspecifica2);
		
		//E as formatações delas
		
		//Utilizar a classe Duration para trabalhar com intervalo de horas.
		LocalTime horaInicial = LocalTime.of(15, 35);
		LocalTime horaFinal = LocalTime.of(16, 35);
		Duration diferenca = Duration.between(horaInicial, horaFinal );
		long s = diferenca.getSeconds(); 
		 System.out.println("A diferença é: " +  String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60)));

	}
}
