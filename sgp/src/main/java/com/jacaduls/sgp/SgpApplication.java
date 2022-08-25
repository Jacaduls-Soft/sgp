package com.jacaduls.sgp;

import entity.Empleado;
import entity.Movimientos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SgpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgpApplication.class, args);

		Empleado empleado1 = new Empleado();
			empleado1.setNombre("Carlos");
			System.out.println("Resultado Empleado: " + empleado1.getNombre());
		Movimientos retiro = new Movimientos();


		}

	}

