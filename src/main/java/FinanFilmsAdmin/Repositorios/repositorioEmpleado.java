package FinanFilmsAdmin.Repositorios;

import FinanFilmsAdmin.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioEmpleado extends JpaRepository<Empleado, Long> {
}
