package com.jacaduls.sgp.repositories;
import com.jacaduls.sgp.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findMovimientosByEmpresa_Id(Long id);
    Movimiento findMovimientoByEmpresa_Id(Long id);
    Movimiento findFirstByEmpresa_Id(Long id);

}




