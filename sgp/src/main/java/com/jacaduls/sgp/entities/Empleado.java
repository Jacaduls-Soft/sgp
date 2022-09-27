package com.jacaduls.sgp.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jacaduls.sgp.enums.Rol;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Controller;


@Entity
public class Empleado {
//    private @Id @GeneratedValue Long id;
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    private String nombre;

    @Column(unique = true)
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "empleado", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Movimiento> movimientos;
//    private Empresa empresa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    //    private Rol rol;
    @Enumerated(value = EnumType.STRING)
//    @ElementCollection(targetClass = Rol.class, fetch = FetchType.LAZY)
    @ElementCollection(targetClass = Rol.class, fetch = FetchType.EAGER)
    @Column(name="rol")
//    private Rol rol;
    private List<Rol> roles;

    @JsonIgnore
    @OneToOne
//    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Empleado() {
    }

    public Empleado(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public void printInfo(){
        if(movimientos != null) System.out.println("[Empleado info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.correo + "\nEmpresa: " + this.empresa + "\nRol: " + this.roles + "\nMovimientos: " + this.movimientos + "\n");
        else System.out.println("[Empleado info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.correo + "\nEmpresa: " + this.empresa + "\nRol: " + this.roles + "\nMovimientos: El empleado aun no realiza movimientos" + "\nUsuario: " + this.usuario +"\n");
    }
}
