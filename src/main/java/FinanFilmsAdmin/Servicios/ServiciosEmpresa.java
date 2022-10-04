package FinanFilmsAdmin.Servicios;

import FinanFilmsAdmin.Entidades.Empleado;
import FinanFilmsAdmin.Entidades.Empresa;
import FinanFilmsAdmin.Repositorios.repositorioEmpresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiciosEmpresa {

    //Atributos de tipo Empresa, luego son objetos

/*
    Empresa empresa1;
    Empresa empresa2;
    Empresa empresa3;

    List<Empresa> listaEmpresas;

// ServiciosEmpleados emple = new ServiciosEmpleados();  //Falta definir la clase ServicioEmpleados


 */


//Constructor en local
    /*
    public ServiciosEmpresa (){
 //   Empleado empleado1 = this.emple.e1;  //Falta definir los empleados

    this.empresa1 = new Empresa("Cinecolombia","Carrera 30 #22",
            "1234","880920");

    this.empresa2 = new Empresa ("Cineland","Calle 50 sur #44",
            "3546","881031");

    this.empresa3 = new Empresa ("Procinal","Carrera 7 #32",
            "5462","883021");

this.listaEmpresas =new ArrayList<>();
listaEmpresas.add(empresa1);
listaEmpresas.add(empresa2);
listaEmpresas.add(empresa3);



    }

     */
    //Metodo Getter para obtener la lista de empresas local
/*
    public List<Empresa> getListaEmpresas(){
return listaEmpresas;
    }
}
*/

    //Utilizando el repositorio
    private repositorioEmpresa repositorioEmp;

    //Constructor con repositorio
    public ServiciosEmpresa (repositorioEmpresa repositorioEmp) {
        this.repositorioEmp = repositorioEmp;
    }

    //Metodo para visualizar a partir del GET
public List<Empresa> getListaEmpresas(){
        return this.repositorioEmp.findAll();

        }
 //Metodo para crear a partir del POST
 public Empresa crearEmpresa (Empresa nuevaEmpresa){
        return this.repositorioEmp.save(nuevaEmpresa);
 }
    //Metodo para actualizar
    public Empresa actualizarEmp(Long id, Empresa emp){
        Empresa empresActual = repositorioEmp.findById(id).orElseThrow();
        empresActual.setNombreEmpresa(emp.getNombreEmpresa());
        empresActual.setDireccionEmpresa(emp.getDireccionEmpresa());
        empresActual.setTelefonoEmpresa(emp.getTelefonoEmpresa());
        return this.repositorioEmp.save(empresActual);

    }
    //Metodo para eliminar
    public Empresa eliminarEmp (Long id){
        Empresa empresActual = repositorioEmp.findById(id).orElseThrow();
        this.repositorioEmp.deleteById(id);
        return empresActual;
    }
    public Empresa getUnicaEmpresa(Long id){
        return repositorioEmp.findById(id).orElseThrow();
    }

}

