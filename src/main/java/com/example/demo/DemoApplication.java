package com.example.demo;

import com.example.demo.model.Guerrero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hola mundo :)");

		Guerrero juan = new Guerrero("Juan", 100);
		System.out.println(juan.getName());
		System.out.println(juan.getAttackPower());

		Guerrero jorge = new Guerrero("Jorge", 200);
		juan.addBrother(jorge);



	}

}
