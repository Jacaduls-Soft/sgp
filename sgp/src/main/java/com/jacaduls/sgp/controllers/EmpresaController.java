package com.jacaduls.sgp.controllers;

import models.Empresa;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {
    @RequestMapping(value = "/enterprise")
    public Empresa getEmpresas() {
        Empresa empresa = new Empresa("MIT", "Fake address 123", "318765676", "1-90988288");
        return empresa;
    }
    @RequestMapping(value = "/enterprise/{id}")
    public Empresa addEmpresa(@PathVariable Long id) {
        Empresa empresa = new Empresa("MIT", "Fake address 123", "318765676", "1-123123123");
        empresa.setId(id);
        return empresa;
    }
}