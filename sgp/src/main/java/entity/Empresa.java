package entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO);
    private  Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleado;

    @OneToMany(mappedBy = "empress")
    private List<entity.Movimiento> movimientos;

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

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleados(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public void printInfo(){
        if(this.empleado != null) System.out.println("[ServEmpresa info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nDireccion: " + this.direccion + "\nNIT: " + this.NIT + "\nEmpleados: " + this.empleado.size() + "\n");
        else System.out.println("[ServEmpresa info]:\n" + "Id: " + this.id + "\nNombre: " + this.nombre + "\nDireccion: " + this.direccion + "\nNIT: " + this.NIT + "\nEmpleados: Aun no hay empleados en esta empresa" + "\n");
    }
}
