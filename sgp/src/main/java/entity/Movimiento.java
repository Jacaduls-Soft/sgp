package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "monto")
    private int monto;
    @Column(name = "concepto")
    private String concepto;

    //    private  ServEmpleado empleado;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    //    private ServEmpresa empresa;
//    @ManyToOne
//    @JoinColumn(name = "empresa_id")
//    private Empresa empresa;

    public Movimiento() {
    }

    public Movimiento(int monto, String concepto) {
        this.monto = monto;
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return this.concepto;
    }

    public void printInfo(){
        System.out.println("[Movimiento info]:\n" + "Id: " + this.id + "\nConcepto: " + this.concepto + "\nMonto: " + this.monto + "\nUsuario: "+ this.empleado );
    }
}
