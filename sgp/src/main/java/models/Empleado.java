package models;

import java.util.List;

import javax.persistence.*;
import enums.Rol;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
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
    @Getter
    @Setter
    private Rol rol;


    public Empleado() {
    }

    public Empleado(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }


    public List<models.Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<models.Movimiento> movimientos) {
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
