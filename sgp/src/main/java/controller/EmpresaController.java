package controller;

import models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repo.EmpresaRepo;

@Controller
public class EmpresaController {
    @Autowired
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
    }
}
