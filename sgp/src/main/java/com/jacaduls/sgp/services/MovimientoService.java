package com.jacaduls.sgp.services;

import com.jacaduls.sgp.entities.Movimiento;
import com.jacaduls.sgp.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository repository;
    public Movimiento add(Movimiento movimiento) {
        return repository.save(movimiento);
    }

    public ResponseEntity<List<Movimiento>> getByEnterpriseById(Long id){
        List<Movimiento> movimientos = new ArrayList<Movimiento>();
        if(id == null)
            repository.findAll().forEach(movimientos::add);
        else
            repository.findMovimeintosByEmpresaId(id).forEach(movimientos::add);
        if(movimientos.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }

    public Movimiento edit(Long id) {
        return null;
    }

    public Movimiento delete(Long id) {
        return null;
    }


}
