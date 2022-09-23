package com.jacaduls.sgp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Empresa {
    private @Id @GeneratedValue Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;
    @JsonIgnore
    @OneToMany(mappedBy = "empresa", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "empresa", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Movimiento> movimientos;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public void printInfo(){
        if(this.empleados != null) System.out.println("[Empresa info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nDireccion: " + this.direccion + "\nNIT: " + this.NIT + "\nEmpleados: " + this.empleados.size() + "\n");
        else System.out.println("[Empresa info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nDireccion: " + this.direccion + "\nNIT: " + this.NIT + "\nEmpleados: Aun no hay empleados en esta empresa" + "\n");
    }
}
