package com.jacaduls.sgp.controllers;
import java.util.List;

import com.jacaduls.sgp.entities.Empleado;
import com.jacaduls.sgp.services.EmpleadoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    List<Empleado> all(){
        return service.getAll();
    }

    @PostMapping("/users")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado) {
        return service.add(newEmpleado);
    }
    @GetMapping("/users/{id}")
    Empleado one(@PathVariable Long id){
        return service.getById(id);
    }

    @PatchMapping("/users/{id}")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado, @PathVariable Long id){
        return service.edit(newEmpleado, id);
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Long id){
        service.delete(id);
    }
}
