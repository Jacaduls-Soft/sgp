package com.jacaduls.sgp.controllers;
import com.jacaduls.sgp.entities.Empresa;
import com.jacaduls.sgp.services.EmpresaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

//    @GetMapping("/enterprises")
//    List<Empresa> all(){
//        return service.getAll();
//    }

    @PostMapping("/enterprises")
    Empresa newEmpresa(@RequestBody Empresa newEmpresa){
        return service.add(newEmpresa);
    }
    @GetMapping("/enterprises/{id}")
    Empresa one(@PathVariable Long id){
        return service.getById(id);
    }


    @PatchMapping("/enterprises/{id}")
    Empresa replaceEmpresa(@RequestBody Empresa newEmpresa, @PathVariable Long id){
        return service.edit(newEmpresa, id);
    }

    @DeleteMapping("/enterprises/{id}")
    void deleteEmpresa(@PathVariable Long id){
        service.delete(id);
    }
}
