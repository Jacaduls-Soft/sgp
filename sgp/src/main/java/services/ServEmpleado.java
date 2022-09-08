package services;

import enums.Rol;
import entity.Movimiento;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ServEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// asigna id incremental
    private long id;
    private String nombre;
    private String correo;
    private Set<Rol> rol = new HashSet<>();
    @OneToMany(mappedBy = "empleado")
    private List<Movimiento> movimientoList;

    }



