package com.jacaduls.sgp.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jacaduls.sgp.enums.Rol;


@Entity
public class Empleado {
//    private @Id @GeneratedValue Long id;
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    private String nombre;
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private List<Movimiento> movimientos;
//    private Empresa empresa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    //    private Rol rol;
    @Enumerated(value = EnumType.STRING)
    @Column(name="rol")
    private Rol rol;


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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    @Override
    public String toString(){
        return this.nombre;
    }

    public void printInfo(){
        if(movimientos != null) System.out.println("[Empleado info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.correo + "\nEmpresa: " + this.empresa + "\nRol: " + this.rol + "\nMovimientos: " + this.movimientos + "\n");
        else System.out.println("[Empleado info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.correo + "\nEmpresa: " + this.empresa + "\nRol: " + this.rol + "\nMovimientos: El empleado aun no realiza movimientos" + "\n");
    }
}
