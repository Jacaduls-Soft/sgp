package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String nombre;

    private String direccion;

    private String telefono;

    private String NIT;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private ArrayList<Empleado> empleados;

    @OneToMany(mappedBy = "empresa")
    private List<Movimiento> movimientos;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }


    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {

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
