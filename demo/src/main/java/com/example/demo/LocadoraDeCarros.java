package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocadoraDeCarros {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraDeCarros.class, args);
		System.out.println("Its online");
	}

}
