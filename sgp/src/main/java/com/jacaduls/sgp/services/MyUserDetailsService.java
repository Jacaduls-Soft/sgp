package com.jacaduls.sgp.services;
import com.jacaduls.sgp.entities.Usuario;
import com.jacaduls.sgp.entities.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);

        Usuario usuario;
        try{
            usuario = usuarioService.getById(username);
            usuario.printInfo();
            System.out.println(usuario.getEmpleado().getRoles());

        }catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }


        return new MyUserDetails(usuario);
    }
}
