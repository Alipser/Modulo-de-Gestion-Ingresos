package FinanFilmsAdmin.Controladores;

import FinanFilmsAdmin.Entidades.Empleado;
import FinanFilmsAdmin.Entidades.Empresa;
import FinanFilmsAdmin.Entidades.MovimientoDinero;
import FinanFilmsAdmin.Servicios.ServiciosEmpresa;
import FinanFilmsAdmin.Servicios.ServiciosMovimientoDinero;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
public class ControlMovimientoDinero {

    private Empresa empresa;
    private ServiciosMovimientoDinero sempresa;

    public ControlMovimientoDinero(ServiciosMovimientoDinero servicio){this.sempresa = servicio;}


    @GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> getMovimientoEmpresa(){
        return sempresa.getServicioMD();
    }
/*
    @GetMapping("/enterprises")
    public List<MovimientoDinero> listadeMovimientos(){
        return this.sempresa.getListaMovD();
    }

 */
    @PostMapping ("/enterprises")
    public RedirectView crearMovimientoDinero (@ModelAttribute MovimientoDinero nuevoMov2, Model modelnm){
        modelnm.addAttribute(nuevoMov2);
        this.sempresa.crearMovimientoDiner(nuevoMov2);
        return new RedirectView("/enterprises");
    }
    @PutMapping("/enterprises/{id}")
    public RedirectView actualizarMd(@PathVariable Long id, MovimientoDinero actMovDinero){
        this.sempresa.actMovimientoDinero(id,actMovDinero);
        return new RedirectView("/enterprises");
    }
    //Metodo borrar registro
    @DeleteMapping("/enterprises/{id}")
    public RedirectView eliminarMd(@PathVariable (value = "id")Long id){
        this.sempresa.delMovimientoDinero(id);
        return new RedirectView("/enterprises");

    }


    /*
    @PatchMapping("/enterprises/{id}/movements/{id2}/{monto}/{ingreso}/{movimiento}")
    public String paMovimientoEmpresa(@PathVariable("id2") long id2,
                                      @PathVariable("monto") float monto,
                                      @PathVariable("ingreso") boolean ingreso,
                                      @PathVariable("movimiento") String movimiento,
                                      @PathVariable("id") long id){
        return sempresa.actMovimientoDinero(id2,monto,ingreso,movimiento);
        }

         @DeleteMapping("/enterprises/{id}/movements/{id2}")
    public String deMovimientoEmpresa(@PathVariable("id") long id,@PathVariable long id2 ){
        return sempresa.delMovimientoDinero(id2);
    }

        */


}
