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

    @GetMapping("/")
    public String EmpresaCont(@RequestParam(name = "name",required = false, defaultValue = "helouu") String name, Model model){
        Empresa empresa =new Empresa();
        repo.save(empresa);
        model.addAttribute("name",name);
        return "index";
    }
}
