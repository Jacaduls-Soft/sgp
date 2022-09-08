package services;

import entity.Movimiento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ServEmpresa {
    private @Id
    @GeneratedValue Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    @OneToMany(mappedBy = "empresa")
    private List<ServEmpleado> empleados;

    @OneToMany(mappedBy = "empresa")
    private List<Movimiento> movimientos;

    public ServEmpresa() {
    }


}