package com.jacaduls.sgp.controllers;

import com.jacaduls.sgp.entities.Movimiento;
import com.jacaduls.sgp.repositories.MovimientoRepository;

import com.jacaduls.sgp.services.MovimientoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientoController {

    MovimientoService service;


    @GetMapping("enterprises/{id_empresa}/movements")
    ResponseEntity<List<Movimiento>> getMovimientosByEnterpriseId(@RequestParam Long id_empresa){
        return service.getByEnterpriseById(id_empresa);
    }

    @PostMapping("enterprises/{id_empresa}/movements")
    Movimiento addMovimiento (@RequestBody Movimiento newMovimiento) {
        return service.add(newMovimiento);
    }

    @PatchMapping("enterprises/{id_empresa}/movements")
    Movimiento editarMovimiento(@RequestParam Long id) {
        return service.edit(id);
    }

    @DeleteMapping("enterprises/{id_empresa}/movements")
    void deleteMovimiento(@RequestParam Long id) {
        service.delete(id);
    }
}
