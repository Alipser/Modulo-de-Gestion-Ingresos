package FinanFilmsAdmin.Servicios;

import FinanFilmsAdmin.Entidades.Usuario;
import FinanFilmsAdmin.Repositorios.repositorioUsuarios;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiciosUsuarios {
    private repositorioUsuarios repositorioUsuarios;

    //Constructor

    public ServiciosUsuarios(FinanFilmsAdmin.Repositorios.repositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public FinanFilmsAdmin.Repositorios.repositorioUsuarios getRepositorioUsuarios() {
        return repositorioUsuarios;
    }

    public void setRepositorioUsuarios(FinanFilmsAdmin.Repositorios.repositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    //Métodos funcionales

    //Función que busca al usuario
    public Usuario buscarPorEmail(String email){
        return this.repositorioUsuarios.findByEmail(email);
    }
    //Funcion que guarda a un nuevo usuario
    public Usuario crearUsuario (Usuario nuevoUsuario){
        return this.repositorioUsuarios.save(nuevoUsuario);
    }
    public Usuario getOrCreateUsuario(Map<String, Object> DatosUsuario){
        String email = (String) DatosUsuario.get("email");
        Usuario usuario = buscarPorEmail(email);
        //Validar usuario existe o no
        if (usuario == null){
            String alias = (String) DatosUsuario.get("nickname");
            String imagen = (String) DatosUsuario.get("picture");
            String auth0Id = (String) DatosUsuario.get("sub");

            Usuario nuevoUsuario = new Usuario(email= email, imagen = imagen, auth0Id = auth0Id);

            return crearUsuario(nuevoUsuario);

        }
    return usuario;
    }
}
