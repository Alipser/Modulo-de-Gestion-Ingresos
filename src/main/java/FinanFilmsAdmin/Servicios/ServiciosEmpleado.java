package FinanFilmsAdmin.Servicios;

import FinanFilmsAdmin.Entidades.Empleado;
import FinanFilmsAdmin.Entidades.Empresa;
import FinanFilmsAdmin.Repositorios.repositorioEmpleado;
import FinanFilmsAdmin.Repositorios.repositorioEmpresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiciosEmpleado {
    private repositorioEmpleado reposEmpleado;


    public ServiciosEmpleado (repositorioEmpleado reposEmpleado) {
        this.reposEmpleado = reposEmpleado;
    }
    public List<Empleado> getListaEmpleados(){
        return this.reposEmpleado.findAll();

    }

    public Empleado crearEmpleado (Empleado nuevoEmpleado){
        return this.reposEmpleado.save(nuevoEmpleado);
    }

    public Empleado actualizarEmpld(Long id, Empleado Empld){
        Empleado EmpleadoActual = reposEmpleado.findById(id).orElseThrow();
        EmpleadoActual.setCedulaEmpleado(Empld.getCedulaEmpleado());
        EmpleadoActual.setNombreEmpledado(Empld.getNombreEmpledado());
        EmpleadoActual.setCorreoEmpleado(Empld.getCorreoEmpleado());
        EmpleadoActual.setEmpresaEmpleado(Empld.getEmpresaEmpleado());
        EmpleadoActual.setRolUsuario(Empld.getRolUsuario());
        return this.reposEmpleado.save(EmpleadoActual);
    }

    public  Empleado eliminarEmpld(Long id){
        Empleado EmpleadoActual = reposEmpleado.findById(id).orElseThrow();
        this.reposEmpleado.deleteById(id);
        return EmpleadoActual;
    }

    public Empleado getUnicoEmpleado(Long id){
        return reposEmpleado.findById(id).orElseThrow();
    }

}




