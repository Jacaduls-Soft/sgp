package com.jacaduls.sgp.services;

import com.jacaduls.sgp.entities.Empresa;
import com.jacaduls.sgp.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> getAll(){
        return repository.findAll();
    }
    public Empresa getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The enterprise was not found"));
    }
    public Empresa add(Empresa empresa) {
        return repository.save((empresa));
    }
    public Empresa edit(Empresa newEmpresa, Long id) {
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
    public void delete (Long id) {
        repository.deleteById(id);
    }
}
