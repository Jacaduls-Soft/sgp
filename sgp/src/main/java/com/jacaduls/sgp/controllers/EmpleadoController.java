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

    @GetMapping("/employees")
    List<Empleado> all(){
        return service.getAll();
    }

    @PostMapping("/employees")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado) {
        return service.add(newEmpleado);
    }
    @GetMapping("/employees/{id}")
    Empleado one(@PathVariable Long id){
        return service.getById(id);
    }

    @PatchMapping("/employees/{id}")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado, @PathVariable Long id){
        return service.edit(newEmpleado, id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        service.delete(id);
    }
}
