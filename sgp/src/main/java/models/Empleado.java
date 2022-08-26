package models;

import java.util.List;

import javax.persistence.*;
import enums.Rol;


@Entity
public class Empleado {
//    private @Id @GeneratedValue Long id;
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    private String nombre;
    private String correo;

    @OneToMany(mappedBy = "empleado")
    private List<Movimiento> movimientos;
//    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    //    private Rol rol;
    @Enumerated(value = EnumType.STRING)
    @Column(name="rol")
    private Rol rol;


    public Empleado() {
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

    @Override
    public String toString(){
        return "[Employee info]:\n" + "id: " + this.id + "\nname: " + this.nombre + "\ncorreo: " + this.correo + "\nEmpresa: " + this.empresa + "\nRol: " + this.rol + "\n";
    }
}
