package FinanFilmsAdmin.Controladores;

import FinanFilmsAdmin.Entidades.Empleado;
import FinanFilmsAdmin.Entidades.Empresa;
import FinanFilmsAdmin.Entidades.MovimientoDinero;
import FinanFilmsAdmin.Entidades.Usuario;
import FinanFilmsAdmin.Servicios.ServiciosEmpresa;
import FinanFilmsAdmin.Servicios.ServiciosMovimientoDinero;
import FinanFilmsAdmin.Servicios.ServiciosUsuarios;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import FinanFilmsAdmin.Servicios.ServiciosEmpleado;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class FrontController {
    ServiciosEmpleado serviciosEmpld;
    ServiciosEmpresa servicioEmp;

    ServiciosMovimientoDinero serviceMov;

    //Aqui hago uso de los servicios de usuarios
    ServiciosUsuarios serviceUs;



    public FrontController (ServiciosEmpleado serviciosEmpld, ServiciosEmpresa serviciosEmp, ServiciosUsuarios serviceUs, ServiciosMovimientoDinero serviceMov){
        this.serviciosEmpld = serviciosEmpld;
        this.servicioEmp = serviciosEmp;
        this.serviceUs = serviceUs;
        this.serviceMov=  serviceMov;

    }



    @GetMapping("/")
    public String Home(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            // System.out.println(principal.getClaims());
            Usuario usuario = this.serviceUs.getOrCreateUsuario(principal.getClaims());
            model.addAttribute("usuario", usuario);
        }

        return "Index";
    }
    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }
    @GetMapping("/empleados")
    public String Empleados2(Model modeloEmpleados){
        List<Empleado> Empleados= this.serviciosEmpld.getListaEmpleados();
        modeloEmpleados.addAttribute("Empleados",Empleados);
        return "frontempleados";
    }

    @GetMapping("/empleados/{id}")
    public String Empleadosid(@PathVariable Long id, Model modeloEmpleadosid){
        Empleado Empleadoid= this.serviciosEmpld.getUnicoEmpleado(id);
        modeloEmpleadosid.addAttribute("empleadoid",Empleadoid);
        return "frontempleadosID";
    }


    @GetMapping("/empresas")
    public String Empresas(Model modeloEmpresas){
        List<Empresa> Empresas = this.servicioEmp.getListaEmpresas();
        modeloEmpresas.addAttribute("Empresas",Empresas);
        return "frontempresas";
    }

    @GetMapping("/empresas/{id}")
    public String Empresaid(@PathVariable Long id, Model modeloEmpresaid){
        Empresa Empresaid= this.servicioEmp.getUnicaEmpresa(id);
        modeloEmpresaid.addAttribute("empresaid",Empresaid);
        return "frontempresasID";
    }

    @GetMapping("/enterprises")
    public String Movimientos(Model modeloMovimientos){
        List<MovimientoDinero> Movimientos = this.serviceMov.getListaMovD();
        modeloMovimientos.addAttribute("Movimientos",Movimientos);
        return "frontenerprises";
    }

    @GetMapping("/enterprises/{id}")
    public String MovDinero(@PathVariable Long id, Model modeloMovimientosid){
        MovimientoDinero MovDineroid= this.serviceMov.getUnicoMov(id);
        modeloMovimientosid.addAttribute("movDineroid",MovDineroid);
        return "frontenterprisesID";
    }


    @GetMapping("empleado/nuevo")
    public String empleadoNuevo (Model model){
        model.addAttribute("empleado",new Empleado());

        return "nuevo-empleado";
    }

    @GetMapping("empresas/nueva")
        public String nuevaEmpresa(Model modelne){
        modelne.addAttribute("emp2",new Empresa());
            return "nueva-empresa";
    }
    @GetMapping("movimiento/nuevo")
    public String nuevaMovimiento(Model modelnm){
        modelnm.addAttribute("nmd",new MovimientoDinero());
        return "nuevo-movimiento";
    }




}
