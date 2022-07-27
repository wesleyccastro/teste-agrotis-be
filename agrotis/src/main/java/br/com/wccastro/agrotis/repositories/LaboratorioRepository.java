package br.com.wccastro.agrotis.repositories;

import br.com.wccastro.agrotis.models.LaboratorioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorioRepository extends JpaRepository<LaboratorioModel, Long> {
}
