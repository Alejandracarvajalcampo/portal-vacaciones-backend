package gestionvacacionesbackend.gestionvacaciones.domain.service;

import gestionvacacionesbackend.gestionvacaciones.domain.repository.EmployeeRepository;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> findById(long id) {
        return employeeRepository.findById(id);
    }
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity, Long id){
        return employeeRepository.findById(id).map(
                employee -> {
                    employee.setNames(employeeEntity.getNames());
                    employee.setSurnames(employeeEntity.getSurnames());
                    employee.setDocumentType(employeeEntity.getDocumentType());
                    employee.setDocument(employeeEntity.getDocument());
                    employee.setPhone(employeeEntity.getPhone());
                    employee.setAddress(employeeEntity.getAddress());
                    employee.setTypeContract(employeeEntity.getTypeContract());
                    employee.setAdmissionDate(employeeEntity.getAdmissionDate());
                    employee.setWithdrawalDate(employeeEntity.getWithdrawalDate());
                    employee.setState(employeeEntity.getState());
                    return employeeRepository.save(employee);
                }
        ).get();
    }
    public void deleteEmployee (Long id) {
        employeeRepository.delete(new EmployeeEntity(id));
    }

}
