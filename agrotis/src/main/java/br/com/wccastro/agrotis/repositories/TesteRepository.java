package br.com.wccastro.agrotis.repositories;

import br.com.wccastro.agrotis.models.TesteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends JpaRepository<TesteModel, Long> {
}
