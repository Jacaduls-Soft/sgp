package com.jacaduls.sgp.repositories;

import com.jacaduls.sgp.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    List<Empleado> getEmpleadosByEmpresaId(Long id);

}
