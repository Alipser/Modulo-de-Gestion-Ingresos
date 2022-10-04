package FinanFilmsAdmin.Servicios;


import FinanFilmsAdmin.Entidades.Empleado;
import FinanFilmsAdmin.Entidades.Empresa;
import FinanFilmsAdmin.Entidades.MovimientoDinero;
import FinanFilmsAdmin.Repositorios.repositorioMovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosMovimientoDinero {

    private repositorioMovimientoDinero repositorio;

    public  ServiciosMovimientoDinero(repositorioMovimientoDinero repositorio){
        this.repositorio = repositorio;
    }

    public List<MovimientoDinero> getServicioMD(){
        return repositorio.findAll();
    }

    public MovimientoDinero crearMovimientoDiner(MovimientoDinero nuevoMovimiento){
        return this.repositorio.save(nuevoMovimiento);
    }


    public MovimientoDinero actMovimientoDinero(Long id,MovimientoDinero nmd){
        MovimientoDinero movdactual = repositorio.findById(id).orElseThrow();;
        movdactual.setMontoMovimiento(nmd.getMontoMovimiento());
        movdactual.setConceptoMovimiento(nmd.getConceptoMovimiento());
        movdactual.setIngreso(nmd.isIngreso());
        return this.repositorio.save(movdactual);
    }
    public List<MovimientoDinero> getListaMovD(){
        return this.repositorio.findAll();

    }
    public MovimientoDinero delMovimientoDinero(Long id){
        MovimientoDinero movd = repositorio.findById(id).orElseThrow();
        this.repositorio.deleteById(id);
        return movd;
    }
    public MovimientoDinero getUnicoMov(Long id){
        return repositorio.findById(id).orElseThrow();
    }

}
