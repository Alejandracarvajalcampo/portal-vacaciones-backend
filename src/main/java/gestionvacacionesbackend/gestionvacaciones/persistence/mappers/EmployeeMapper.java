package gestionvacacionesbackend.gestionvacaciones.persistence.mappers;


import gestionvacacionesbackend.gestionvacaciones.domain.dto.Employee;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployee (EmployeeEntity employeeEntity);
    EmployeeEntity toEmployeeEntity (Employee employee);
}
