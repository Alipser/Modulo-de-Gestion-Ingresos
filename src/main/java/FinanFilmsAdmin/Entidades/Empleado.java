package FinanFilmsAdmin.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "Empleado")
public class Empleado {

    //Se cambio de privado a publico la cedula
    @Id

    public Long CedulaEmpleado;

    @Column(name="Nombre_Empleado")
    public String NombreEmpledado;
    @Column(name = "correo_empleado")
    private String CorreoEmpleado;

    @ManyToOne(optional = true)
    @JoinColumn(name = "nit_empresa")
    private Empresa EmpresaEmpleado;
    @Column(name = "rol_usuario")
    private String RolUsuario;

    @OneToMany(mappedBy = "Empleado")
    
    //Instruccion para evitar el bucle movimiendodinero
    @JsonIgnoreProperties(value = "MovimientoDineroEmp")
    private Set<MovimientoDinero> MovimientoDineroEmp;


//Nuevo Constructor
    public Empleado(){

    }



    public String getCorreoEmpleado() {
        return CorreoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        CorreoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return EmpresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        EmpresaEmpleado = empresaEmpleado;

    }

    public String getRolUsuario() {
        return RolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        RolUsuario = rolUsuario;
    }
     public String getNombreEmpledado() {
        return NombreEmpledado;
    }

    public void setNombreEmpledado(String nombreEmpledado) {
        NombreEmpledado = nombreEmpledado;
    }

    public Long getCedulaEmpleado() {
        return CedulaEmpleado;
    }

    public void setCedulaEmpleado(Long cedulaEmpleado) {
        CedulaEmpleado = cedulaEmpleado;
    }

    public Set<MovimientoDinero> getMovimientoDineroEmp() {
        return MovimientoDineroEmp;
    }

    public void setMovimientoDineroEmp(Set<MovimientoDinero> movimientoDineroEmp) {
        MovimientoDineroEmp = movimientoDineroEmp;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + CedulaEmpleado + '\'' +
                ", CorreoEmpleado='" + CorreoEmpleado + '\'' +
                ", EmpresaEmpleado='" + EmpresaEmpleado + '\'' +
                ", RolUsuario='" + RolUsuario + '\'' +
                '}';
    }
}
