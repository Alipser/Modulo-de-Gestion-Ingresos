package FinanFilmsAdmin.Repositorios;

import FinanFilmsAdmin.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioEmpresa extends JpaRepository<Empresa, Long> {
}
