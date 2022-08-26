package com.jacaduls.sgp;

import enums.Rol;
import models.Empleado;
import models.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SgpApplication {

	public static void main(String[] args) {


		SpringApplication.run(SgpApplication.class, args);

		Empresa empresa = new Empresa("Corp", "Fake St. 123", "1234568", "111222333");

		empresa.setId(Long.valueOf(1));
		empresa.printInfo();


		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Montgomery Burns");
		empleado1.setCorreo("mburns@mail.com");
		empleado1.setId(Long.valueOf(1));
		empleado1.setRol(Rol.Admin);
		empleado1.setEmpresa(empresa);

		empleado1.printInfo();

		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Homer Simpson");
		empleado2.setCorreo("hsimpson@mail.com");
		empleado2.setId(Long.valueOf(2));
		empleado2.setRol(Rol.Operario);
		empleado2.setEmpresa(empresa);

		empleado2.printInfo();

		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado1);
		empleados.add(empleado2);
		empresa.setEmpleados(empleados);

		empresa.printInfo();
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello %s!", name);
	}

}
