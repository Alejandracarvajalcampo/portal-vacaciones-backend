package gestionvacacionesbackend.gestionvacaciones.domain.repository;


import gestionvacacionesbackend.gestionvacaciones.persistence.entities.VacationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequestEntity, Long> {
}
