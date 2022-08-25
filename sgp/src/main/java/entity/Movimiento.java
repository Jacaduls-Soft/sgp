package entity;

import javax.persistence.*;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer mpnto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleadoId")
    private  Empleado empleado;
}
