
package FinanFilmsAdmin.Controladores;

import FinanFilmsAdmin.Entidades.Empresa;
import FinanFilmsAdmin.Servicios.ServiciosEmpresa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlEmpresa {

    //prueba visualizacion
/*
 @GetMapping("/empresa")
public String visualizar (){
return "Primera vista empresa";
 }
@GetMapping("vistaempresa")
    public Empresa ControlEmpresa(){
Empresa empresa1 = new Empresa("Cinecolombia","Carrera 30 #22",
        "314857","880710-1");
return empresa1;
}
*/
    //Implementando las herramientas JPA

    ServiciosEmpresa servicioEmp;

    //Constructor

    public ControlEmpresa (ServiciosEmpresa servicioEmp){
        this.servicioEmp = servicioEmp;
    }

/*
    @GetMapping("/empresas")
    public List<Empresa> listaEmpresas(){
        return this.servicioEmp.getListaEmpresas();
    }


 */


    @PostMapping ("/empresas")
    public Empresa crearEmpresa(@RequestBody Empresa emp){
        return this.servicioEmp.crearEmpresa(emp);
    }
    //Metodo editar un registro
    @PutMapping("/empresas/{id}")
    public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa actEmpresa){
        return this.servicioEmp.actualizarEmp(id,actEmpresa);
    }
    //Metodo borrar registro
    @DeleteMapping("/eliminar/{id}")
    public Empresa eliminarEmpresa(@PathVariable (value = "id")Long id){
        return this.servicioEmp.eliminarEmp(id);

    }

}
