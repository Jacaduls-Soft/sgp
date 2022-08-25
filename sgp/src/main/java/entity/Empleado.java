package entity;

import enums.Rol;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// asigna id incremental
    private long id;
    private String nombre;
    private String correo;
    private Set<Rol> rol = new HashSet<>();
    @OneToMany(mappedBy = "empleado")
    private List<Movimiento> movimientoList;
    public Empleado(){};
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
