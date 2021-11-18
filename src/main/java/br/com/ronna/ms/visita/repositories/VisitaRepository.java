package br.com.ronna.ms.visita.repositories;

import br.com.ronna.ms.visita.models.VisitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitaRepository extends PagingAndSortingRepository<VisitaModel, Long> {


}
