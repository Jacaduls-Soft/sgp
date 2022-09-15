package com.jacaduls.sgp.repositories;
import com.jacaduls.sgp.entities.Movimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findMovimeintosByEmpresaId(Long id);
    List<Movimiento> findMovimeintosByConcepto(String concepto);
}
