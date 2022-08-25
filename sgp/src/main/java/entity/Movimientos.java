package entity;

import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Entity
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer mpnto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleadoId")
    private  Empleado empleado;
}
