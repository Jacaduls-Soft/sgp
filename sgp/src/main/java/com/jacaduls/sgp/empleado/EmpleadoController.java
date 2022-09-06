package com.jacaduls.sgp.empleado;
import java.util.List;
import java.lang.RuntimeException;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadoController {

    private final EmpleadoRepository repository;

    public EmpleadoController(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Empleado> all(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado) {
        return repository.save(newEmpleado);
    }

    @GetMapping("/employees/{id}")
    Empleado one(@PathVariable Long id){
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PutMapping("/employees/{id}")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado, @PathVariable Long id){

        return repository.findById(id)
            .map(empleado -> {
                empleado.setNombre(newEmpleado.getNombre());
                empleado.setCorreo(newEmpleado.getCorreo());
                empleado.setEmpresa(newEmpleado.getEmpresa());
                return repository.save(empleado);
            })
            .orElseGet(() -> {
                newEmpleado.setId(id);
                return repository.save(newEmpleado);
        });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
