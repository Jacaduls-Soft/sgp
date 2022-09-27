package com.jacaduls.sgp.controllers;

import com.jacaduls.sgp.entities.Movimiento;

import com.jacaduls.sgp.services.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoController {

    private final MovimientoService service;

    public MovimientoController(MovimientoService service) {
        this.service = service;
    }

    @GetMapping("/enterprises/{id}/movements")
    ResponseEntity<List<Movimiento>> getMovimientosByEnterpriseId(@PathVariable Long id){
        return service.getByEnterpriseById(id);
    }

//    @PostMapping("/enterprises/{id}/movements")
//    Movimiento addMovimiento (@RequestBody Movimiento newMovimiento, @PathVariable Long id) {
//        return service.add(id, newMovimiento);
//    }

    @PostMapping("/enterprises/{id}/movements")
    ResponseEntity<Movimiento> addMovimiento (@RequestBody Movimiento newMovimiento, @PathVariable Long id) {
        return service.add(id, newMovimiento);
    }

//    @PatchMapping("/enterprises/{id}/movements")
//    Movimiento editarMovimiento(@RequestBody Movimiento newMovimiento, @PathVariable Long id) {
//        return service.edit(newMovimiento, id);
//    }

    @PatchMapping("/enterprises/{id}/movements")
    ResponseEntity<Movimiento> editMovimiento(@RequestBody Movimiento newMovimiento, @PathVariable Long id) {
        return service.edit(newMovimiento, id);
    }

    @DeleteMapping("/enterprises/{id}/movements")
    void deleteMovimientos(@PathVariable Long id) {
        service.deleteAll(id);
    }

    @DeleteMapping("/movements/{id}")
    void deleteMovimiento(@PathVariable Long id){
        service.deleteOne(id);
    }


}
