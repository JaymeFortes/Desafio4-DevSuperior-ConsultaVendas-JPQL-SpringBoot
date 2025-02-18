package com.Desafio4_ConsultaVendas_JPQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio4Application implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(Desafio4Application.class, args);
	}

}
