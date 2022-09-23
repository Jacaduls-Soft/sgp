package com.jacaduls.sgp.repositories;

import com.jacaduls.sgp.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
