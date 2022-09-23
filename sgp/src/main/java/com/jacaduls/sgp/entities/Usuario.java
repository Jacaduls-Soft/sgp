package com.jacaduls.sgp.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @Column(unique = true)
    private String correo;

    private String password;
    private String phone;

//    @OneToOne
//    @JoinColumn(name = "empleado_id")
    @OneToOne(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Empleado empleado;

    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    public Usuario() {
    }

    public Usuario(String correo, String password, String phone, Date createdAt, Date updatedAt) {
        this.correo = correo;
        this.password = password;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void printInfo(){
        System.out.println("[Usuario info]:\n" + "Id: " + this.correo + "\nContraseña: " + this.password + "\nEmpleado: " + this.empleado + "\n");
    }
}
