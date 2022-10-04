package FinanFilmsAdmin.Entidades;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table (name = "MovimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long Id;
    @Column(name = "monto_movimiento")
    private float MontoMovimiento;
    @Column(name = "ingreso")
    private boolean Ingreso;
    @Column(name = "concepto_movimiento")
    private String ConceptoMovimiento;
    @ManyToOne(optional = false)
    @JoinColumn(name = "CedulaEmpleado", nullable = false)
    //Instruccion para evitar el bucle en movimientodinero
    @JsonIgnoreProperties(value= "Empleado")
    private Empleado Empleado;






    //Nuevo constructor
    public MovimientoDinero(){

    }
@Transient
private float positivos = 0;
@Transient
private float negativos = 0;


    public float getMontoMovimiento() {
        if (isIngreso()==false) {
            this.negativos+= MontoMovimiento;
            return MontoMovimiento*=-1;
        }
        this.positivos+= MontoMovimiento;
        return MontoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {
        MontoMovimiento = montoMovimiento;
    }

    public boolean isIngreso() {
        return Ingreso;
    }

    public void setIngreso(boolean ingreso) {
        Ingreso = ingreso;
    }

    public String getConceptoMovimiento() {
        return ConceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        ConceptoMovimiento = conceptoMovimiento;
    }

    public FinanFilmsAdmin.Entidades.Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(FinanFilmsAdmin.Entidades.Empleado empleado) {
        Empleado = empleado;
    }



}
