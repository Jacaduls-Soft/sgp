package com.jacaduls.sgp.services;

import com.jacaduls.sgp.entities.Empleado;
import com.jacaduls.sgp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository repository;
    public List<Empleado> getAll(){
        return repository.findAll();
    }

    public Empleado getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    public Empleado add(Empleado newEmpleado) {
        return repository.save(newEmpleado);
    }
    public Empleado edit(Empleado newEmpleado, Long id) {
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
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //nuevos metodos

    public List<Empleado> getEmpleadosByEmpresaId(Long id){
        return repository.getEmpleadosByEmpresaId(id);
    }
}
