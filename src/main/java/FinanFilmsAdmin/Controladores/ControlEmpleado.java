package FinanFilmsAdmin.Controladores;

import FinanFilmsAdmin.Entidades.Empleado;
import FinanFilmsAdmin.Servicios.ServiciosEmpleado;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ControlEmpleado {

    ServiciosEmpleado serviciosEmpld;

    public ControlEmpleado (ServiciosEmpleado serviciosEmpld){
        this.serviciosEmpld = serviciosEmpld;
    }

    /*@GetMapping("/empleados")
    public List<Empleado> listaEmpleados(){
        return this.serviciosEmpld.getListaEmpleados();
    }
    @GetMapping("/empleados/{id}")
    public Empleado UnicoEmpleado(@PathVariable Long id){
        return this.serviciosEmpld.getUnicoEmpleado(id);
    }


     */

    /*
    @PostMapping("/empleados")
    public Empleado crearEmpleado (@ModelAttribute Empleado empleadoNuevo, Model model){
        model.addAttribute(empleadoNuevo);
        return this.serviciosEmpld.crearEmpleado(empleadoNuevo);
    }

     */
//Omitiendo la salida del json en el navegador
    @PostMapping ("/empleados")
    public RedirectView crearEmpleado (@ModelAttribute Empleado empleadoNuevo, Model model){
        model.addAttribute(empleadoNuevo);
        this.serviciosEmpld.crearEmpleado(empleadoNuevo);
        return new RedirectView("/empleados");
    }











    @PutMapping("/empleados/{id}")
    public RedirectView actualizarEmpleado(@PathVariable Long id, Empleado actEmpleado){
        this.serviciosEmpld.actualizarEmpld(id,actEmpleado);
        return new RedirectView("/empleados");
    }
    //Metodo borrar registro
    @DeleteMapping("/empleados/{id}")
    public RedirectView eliminarEmpleado(@PathVariable (value = "id")Long id){
        this.serviciosEmpld.eliminarEmpld(id);
        return new RedirectView("/empleados");

    }
}
