package models;

import javax.persistence.*;

@Entity
public class Movimiento {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private int monto;
    private String concepto;

    //    private  Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    //    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Movimiento() {
    }


}
