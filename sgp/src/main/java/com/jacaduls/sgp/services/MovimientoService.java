package com.jacaduls.sgp.services;

import com.jacaduls.sgp.entities.Empresa;
import com.jacaduls.sgp.entities.Movimiento;
import com.jacaduls.sgp.repositories.MovimientoRepository;
import com.jacaduls.sgp.repositories.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository repository;
    private final EmpresaRepository empresaRepository;

    public MovimientoService(MovimientoRepository repository, EmpresaRepository empresaRepository) {
        this.repository = repository;
        this.empresaRepository = empresaRepository;
    }

    public ResponseEntity<Movimiento> add(Long id, Movimiento movimiento) {

        if (empresaRepository.findById(id).isPresent()){
            Empresa empresa = empresaRepository.findById(id).get();
            movimiento.setEmpresa(empresa);
//            return repository.save(movimiento);
            return new ResponseEntity<>(repository.save(movimiento), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Movimiento>> getByEnterpriseById(Long id){
        return new ResponseEntity<>(repository.findMovimientosByEmpresa_Id(id), HttpStatus.OK);
    }

    public ResponseEntity<Movimiento> edit(Movimiento newMovimiento, Long id) {
       Movimiento movimiento = repository.findFirstByEmpresa_Id(id);
//        repository.findAll().forEach(movimientos::add);

       if(movimiento == null){
           return this.add(id, newMovimiento);
       }
       else {
           movimiento.setConcepto(newMovimiento.getConcepto());
           movimiento.setMonto(newMovimiento.getMonto());

//           return repository.save(movimiento);
           return new ResponseEntity<>(repository.save(movimiento), HttpStatus.OK);
       }
    }
    public void deleteAll(Long id) {
        List<Movimiento> movimientos = repository.findMovimientosByEmpresa_Id(id);

        repository.deleteAll(movimientos);
    }

    public void deleteOne(Long id){
        repository.deleteById(id);
    }

}
