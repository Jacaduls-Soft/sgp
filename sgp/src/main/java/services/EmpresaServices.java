package services;

import models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmpresaRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServices {

    @Autowired
    EmpresaRepo repoEmpresa;

    public void CrearEmpresa(Empresa empresa){
        repoEmpresa.save(empresa);
    }
    public List verEmpresa(){
        List<Empresa>empresaList = new ArrayList<Empresa>();
        empresaList.addAll(repoEmpresa.findAll());
        return empresaList;
    }
    public void EliminarEmpresa( Long id){
        repoEmpresa.deleteById(Math.toIntExact(id));
    }
    public void EditarEmpresa(){}



}
