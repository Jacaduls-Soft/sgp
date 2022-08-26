package com.jacaduls.sgp;

import enums.Rol;
import models.Empleado;
import models.Empresa;
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

		Empresa empresa = new Empresa("Corp", "Fake St. 123", "1234568", "111222333");

		empresa.printInfo();


		Empleado empleado = new Empleado();
		empleado.setCorreo("test@mail.com");
		empleado.setNombre("Test employee");
		empleado.setId(Long.valueOf(1));
		empleado.setRol(Rol.Admin);
		empleado.setEmpresa(empresa);

		System.out.println(empleado.toString());

	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello %s!", name);
	}

}
