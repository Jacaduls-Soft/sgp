package com.jacaduls.sgp.controllers.frontend;

import com.jacaduls.sgp.controllers.MovimientoController;
import com.jacaduls.sgp.entities.Empleado;
import com.jacaduls.sgp.entities.Movimiento;
import com.jacaduls.sgp.entities.Usuario;
import com.jacaduls.sgp.enums.Rol;
import com.jacaduls.sgp.services.EmpresaService;
import com.jacaduls.sgp.services.MovimientoService;
import com.jacaduls.sgp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/home")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model, Authentication auth){
        model.addAttribute("users",usuarioService.getAll());
        Usuario user = usuarioService.getById(auth.getName());
        Long id = user.getEmpleado().getEmpresa().getId();
        model.addAttribute("empresaId", id);
        return "users";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new Usuario());
        return "login";
    }

    @GetMapping("/enterprises/{id}/movements")
    public String getMovementsByEnterprise(@PathVariable Long id, Model model) {
        ResponseEntity<List<Movimiento>> movimientos = movimientoService.getByEnterpriseById(id);
        model.addAttribute("movements", movimientos.getBody());
        System.out.println("Size:::::: " + movimientos.getBody().size());
        return ("/movements");
    }

    @GetMapping("/create/movement")
    public String getCreateMovement(Model model) {
        model.addAttribute("movement", new Movimiento());
        return "createMovement";
    }

    @PostMapping("/create/movement")
    public String postCreateMovement(@ModelAttribute Movimiento movimiento, Authentication auth) {
        System.out.println("COrreoooo" + auth.getName());
        movimiento.setEmpleado(usuarioService.getById(auth.getName()).getEmpleado());
        movimiento.setEmpresa(usuarioService.getById(auth.getName()).getEmpleado().getEmpresa());
        movimientoService.add(usuarioService.getById(auth.getName()).getEmpleado().getEmpresa().getId(), movimiento);
        return "redirect:/movements" + usuarioService.getById(auth.getName()).getEmpleado().getEmpresa().getId() + "/movements";
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
        model.addAttribute("empresas", empresaService.getAll());

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
