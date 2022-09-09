package controller;

import entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ServEmpresa;

import java.util.List;

@RestController
public class EmpresaController {
    //Comunicacion controler con services
    @Autowired
    ServEmpresa empresaServices;
    @GetMapping("/empresa")
    private List<Empresa> verEmpresa(){
        return empresaServices.verEmpresa();
    }
    @PostMapping("/empresa")
    private void crearEmpresa(@RequestBody Empresa empresa){

        empresaServices.CrearEmpresa(empresa);
    }
    @DeleteMapping("/empresa/{id}")   //patvariable desde url
    private void eliminarEmpresa(@PathVariable("id")Long id) {
        empresaServices.EliminarEmpresa(id);
    }

    @PutMapping("/empresa")   //patvariable desde url
    private void editarEmpresa(@RequestBody Empresa empresa) {
        empresaServices.EditarEmpresa();
    }

    /*

   private EmpresaRepo repo;

    @GetMapping("/empresa")
    public String EmpresaCont(@RequestParam(name = "name",required = false, defaultValue = "helouu") String name, Model model){

        Empresa emp1 =new Empresa();
        emp1.setId(Long.valueOf(1));
        emp1.setNIT("900589");
        emp1.setNombre("Cars");
        emp1.setDireccion("Cra 3 #1");
        emp1.setTelefono("54521");


        repo.save(emp1);

        model.addAttribute("name",name);
        return "index";

    */
}
