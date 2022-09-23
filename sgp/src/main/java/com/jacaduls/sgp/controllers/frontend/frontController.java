package com.jacaduls.sgp.controllers.frontend;

import com.jacaduls.sgp.entities.Empleado;
import com.jacaduls.sgp.entities.Usuario;
import com.jacaduls.sgp.enums.Rol;
import com.jacaduls.sgp.services.EmpresaService;
import com.jacaduls.sgp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import com.jacaduls.sgp.services.EmpleadoService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class frontController {


    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/home")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users",usuarioService.getAll());
        return "users";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new Usuario());
        return "login";
    }

    @GetMapping("/create/user")
    public String getCreateUser(Model model){
        model.addAttribute("user", new Usuario());
        return "createUser";
    }

    @PostMapping("/create/user")
    public String postCreateUser(@ModelAttribute Usuario usuario){

//        usuario.printInfo();

        usuarioService.add(usuario);

        return "redirect:/create/user/"+ usuario.getCorreo() +"/employee";
//        return "redirect:/create/employee";
    }

    @GetMapping("/create/user/{id}/employee")
    public String getCreateEmployee(@PathVariable String id, Model model){

        Empleado empleado = new Empleado();
        List<String> roles = new ArrayList<>();

        Usuario usuario = usuarioService.getById(id);

        empleado.setUsuario(usuario);
        empleado.setCorreo(id);


        model.addAttribute("employee", empleado);

        for (Rol rol:Rol.values()){
            roles.add(rol.name());
        }

        model.addAttribute("roles", roles);
        model.addAttribute("enterprises", empresaService.getAll());

        return "createEmployee";
    }

    @PostMapping("/create/employee")
    public String postCreateUser(@ModelAttribute("employee") Empleado empleado) {

        empleado.printInfo();

        empleadoService.add(empleado);

        return "redirect:/users";
    }

    @GetMapping("/delete/user/{id}")
    public String getDeleteUser(@PathVariable String id){

        Usuario usuario = usuarioService.getById(id);
        usuarioService.delete(usuario);

        return "redirect:/users";
    }




//    @PostMapping("/create/user/{id}/employee")
//    public String postCreateUser(@PathVariable String id, @ModelAttribute("employee") Empleado employee) {
//
//        Usuario usuario = usuarioService.getById(id);
//        employee.setUsuario(usuario);
//        employee.setCorreo(usuario.getCorreo());
//
//        empleadoService.add(employee);
//        return "redirect:/home";
//    }



//    @PostMapping("/login")
//    public String postLogin(@ModelAttribute("user") Usuario usuario)
//    {
//        usuario.printInfo();
//        return "redirect:/home";
//    }
}
