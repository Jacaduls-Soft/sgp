package com.jacaduls.sgp.controllers;

import models.Movimiento;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientoController {

    @RequestMapping(value = "/enterprise/{id}/movements")
    public List<Movimiento> getMovimientos(@PathVariable Long id){
        List<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(new Movimiento(1500, "Papitas"));
        movimientos.get(0).setId(id);
        return movimientos;
    }
}