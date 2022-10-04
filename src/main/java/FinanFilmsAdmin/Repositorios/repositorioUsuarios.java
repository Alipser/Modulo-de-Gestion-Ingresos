package FinanFilmsAdmin.Repositorios;

import FinanFilmsAdmin.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioUsuarios extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
