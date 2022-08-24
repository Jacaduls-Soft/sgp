package entity;

import enums.Rol;

import java.util.HashSet;
import java.util.Set;


public class Empleado {
    private String nombre;
    private String correo;
    private Set<Rol> rol = new HashSet<>();

    public Empleado(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Rol> getRol() {
        return rol;
    }

    public void setRol(Set<Rol> rol) {
        this.rol = rol;
    }
}
