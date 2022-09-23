package com.jacaduls.sgp.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.jacaduls.sgp.enums.Rol;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetails {


    private final String username;
    private final String password;

    private final List<GrantedAuthority> authorities;

//    private GrantedAuthority authority;

    public MyUserDetails(Usuario usuario) {
        this.username = usuario.getCorreo();
        this.password = usuario.getPassword();
        this.authorities = new ArrayList<>();

        for (Rol rol:usuario.getEmpleado().getRoles()) {
            this.authorities.add(new SimpleGrantedAuthority(rol.name()));
        }

//        this.authorities.add(new SimpleGrantedAuthority(usuario.getEmpleado().getRol().name()));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
