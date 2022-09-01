package com.jacaduls.sgp.controllers;

import models.Empleado;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "/users")
    public Empleado getUsuarios() {
        Empleado usuario = new Empleado("Dujardin Pizarro", "duj@gmail.com");
        return usuario;
    }

    @RequestMapping(value = "/user/{id}")
    public Empleado getUsuario(@PathVariable Long id){
        Empleado usuario = new Empleado("Dujardin Pizarro", "duj@gmail.com");
        usuario.setId(id);
        return usuario;
    }
}
