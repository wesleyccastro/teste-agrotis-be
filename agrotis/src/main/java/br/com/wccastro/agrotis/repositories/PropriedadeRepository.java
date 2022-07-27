package br.com.wccastro.agrotis.repositories;

import br.com.wccastro.agrotis.models.PropriedadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends JpaRepository<PropriedadeModel, Long> {
}
