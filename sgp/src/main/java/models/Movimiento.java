package models;

import javax.persistence.*;

@Entity
public class Movimiento {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
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

    public Movimiento(int monto, String concepto) {
        this.monto = monto;
        this.concepto = concepto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    @Override
    public String toString() {
        return this.concepto;
    }

    public void printInfo(){
        System.out.println("[Movimiento info]:\n" + "Id: " + this.id + "\nConcepto: " + this.concepto + "\nMonto: " + this.monto + "\nUsuario: " + this.empleado + "\nEmpresa: " + this.empresa + "\n");
    }
}
