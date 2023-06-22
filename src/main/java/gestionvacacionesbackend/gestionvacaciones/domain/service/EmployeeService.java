package gestionvacacionesbackend.gestionvacaciones.domain.service;

import gestionvacacionesbackend.gestionvacaciones.domain.dto.Employee;
import gestionvacacionesbackend.gestionvacaciones.domain.dto.VacationRequest;
import gestionvacacionesbackend.gestionvacaciones.domain.repository.EmployeeRepository;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.VacationRequestEntity;
import gestionvacacionesbackend.gestionvacaciones.persistence.mappers.EmployeeMapper;
import gestionvacacionesbackend.gestionvacaciones.persistence.mappers.VacationRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private VacationRequestMapper vacationRequestMapper;

    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.save(employeeMapper.toEmployeeEntity(employee));
        return employeeMapper.toEmployee(employeeEntity);
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = (List<EmployeeEntity>) employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntities) {
            Employee employee = employeeMapper.toEmployee(employeeEntity);
            employees.add(employee);
        }

        return employees;
    }

    public Optional<Employee> findEmployeeById(long id) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);

        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            Employee employee = employeeMapper.toEmployee(employeeEntity);
            return Optional.of(employee);
        }

        return Optional.empty();
    }

    public Optional<Employee> findEmployeeByDocument(Integer document) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findByDocument(document);

        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            Employee employee = employeeMapper.toEmployee(employeeEntity);
            return Optional.of(employee);
        }

        return Optional.empty();
    }

    public Employee updateEmployee(Employee employee, Long id) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {


            EmployeeEntity updatedEmployeeEntity = employeeRepository.save(employeeMapper.toEmployeeEntity(employee));
            return employeeMapper.toEmployee(updatedEmployeeEntity);
        }

        return null; // O puedes lanzar una excepción o devolver un ResponseEntity con un estado de respuesta apropiado
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<VacationRequest> searchRequestByEmployeeDocument (Integer document){
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findByDocument(document);
        if(employeeEntityOptional.isPresent()){
         EmployeeEntity employeeEntity = employeeEntityOptional.get();
          List<VacationRequestEntity> vacations = employeeEntity.getVacation();
          return vacationRequestMapper.toVacationRequest(vacations);
        }
        return new ArrayList<>();

    }
}
