package com.jacaduls.sgp.empresa;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import repositories.EmpresaRepository;
import java.util.List;

@RestController
public class EmpresaController {
    private final EmpresaRepository repository;

    public EmpresaController(EmpresaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/enterprises")
    List<Empresa> all(){
        return repository.findAll();
    }

    @PostMapping("/enterprises")
    Empresa newEmpresa(@RequestBody Empresa newEmpresa){
        return repository.save((newEmpresa));
    }

    @GetMapping("/enterprises/{id}")
    Empresa one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The enterprise was not found"));
    }

    @PutMapping("/enterprises/{id}")
    Empresa replaceEmpresa(@RequestBody Empresa newEmpresa, @PathVariable Long id){
        return repository.findById(id)
            .map(empresa -> {
                empresa.setNombre(newEmpresa.getNombre());
                empresa.setDireccion(newEmpresa.getDireccion());
                empresa.setTelefono(newEmpresa.getTelefono());
                empresa.setNIT(newEmpresa.getNIT());
                return repository.save(empresa);
            })
            .orElseGet(() -> {
                newEmpresa.setId(id);
                return repository.save(newEmpresa);
            });
    }

    @DeleteMapping("/enterprises/{id}")
    void deleteEmpresa(@PathVariable Long id){
        repository.deleteById(id);
    }
}
