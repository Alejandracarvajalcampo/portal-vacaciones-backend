package gestionvacacionesbackend.gestionvacaciones.domain.repository;

import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Long>  {

}
