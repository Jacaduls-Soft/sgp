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
import org.springframework.web.bind.annotation.*;
import com.jacaduls.sgp.services.EmpleadoService;

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


    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/home")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users",usuarioService.getAll());
        return "pages/users";
    }
    @GetMapping("/enterprise")
    public String getEnterprises(Model model){
        model.addAttribute("enterprises",empresaService.getAll());
        System.out.println(empresaService.getAll() + "22222222222222222222222222222");
        return "pages/enterprises";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new Usuario());
        return "pages/login";
    }

    @GetMapping("/create/user")
    public String getCreateUser(Model model){
        model.addAttribute("user", new Usuario());
        return "/pages/nuevoUsuario";
    }

    @PostMapping("/create/user")
    public String postCreateUser(@ModelAttribute Usuario usuario, Model model){
        model.addAttribute("usuario", usuario);
        usuarioService.add(usuario);
        return "pages/createUser";
//        usuario.printInfo();


//        return "redirect:/create/user/"+ usuario.getCorreo() +"/employee";
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
//        System.out.println("Entró al maldito metodo de login");
//        usuario.printInfo();
//        return "redirect:/home";
//    }
}
