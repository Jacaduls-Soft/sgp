package com.jacaduls.sgp.services;

import com.jacaduls.sgp.entities.Usuario;
import com.jacaduls.sgp.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario getById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Usuario> getAll(){
        return repository.findAll();
    }

    public Usuario add(Usuario usuario){
        return repository.save(usuario);
    }

    public void delete(Usuario usuario){
        repository.delete(usuario);
    }
}
