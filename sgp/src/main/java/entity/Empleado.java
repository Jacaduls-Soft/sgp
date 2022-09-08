package entity;

import java.util.List;

import javax.persistence.*;
import enums.Rol;
import lombok.Getter;
import lombok.Setter;

//vea
@Entity
@Getter
@Setter
public class Empleado {

//    private @Id @GeneratedValue Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String correo;
    @OneToMany(mappedBy = "empleado")
    private List<Movimiento> movimientos;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    //    private Rol rol;
    @Enumerated(value = EnumType.STRING)
    @Column(name="rol")
    @Getter
    @Setter
    private Rol rol;


    public Empleado() {
    }

    public Empleado(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }


    public List<entity.Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<entity.Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public void printInfo(){
        if(movimientos != null) System.out.println("[ServEmpleado info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.correo + "\nServEmpresa: " + this.empresa + "\nRol: " + this.rol + "\nMovimientos: " + this.movimientos + "\n");
        else System.out.println("[ServEmpleado info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.correo + "\nServEmpresa: " + this.empresa + "\nRol: " + this.rol + "\nMovimientos: El empleado aun no realiza movimientos" + "\n");
    }
}
