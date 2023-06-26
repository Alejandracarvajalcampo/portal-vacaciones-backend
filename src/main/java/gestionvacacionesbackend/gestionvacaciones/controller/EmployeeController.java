package gestionvacacionesbackend.gestionvacaciones.controller;

import gestionvacacionesbackend.gestionvacaciones.domain.Exceptions.ResourceNotFoundException;
import gestionvacacionesbackend.gestionvacaciones.domain.dto.Employee;
import gestionvacacionesbackend.gestionvacaciones.domain.dto.VacationRequest;
import gestionvacacionesbackend.gestionvacaciones.domain.repository.EmployeeRepository;
import gestionvacacionesbackend.gestionvacaciones.domain.service.EmployeeService;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.VacationRequestEntity;
import gestionvacacionesbackend.gestionvacaciones.persistence.mappers.VacationRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VacationRequestMapper vacationRequestMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("list/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("search/{document}")
    public ResponseEntity<Employee> getEmployedByDocument(@Valid @PathVariable Integer document) {
        Employee employee = employeeService.findEmployeeByDocument(document).orElseThrow(() -> new ResourceNotFoundException(("no existe el empleado con ese dpcumento:" + document)));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee) {

        Employee updated = employeeService.updateEmployee(updatedEmployee);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@Valid @PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vacation-requests/{document}")
    public List<VacationRequest> searchRequestByEmployeeDocument(@PathVariable Integer document) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findByDocument(document);
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            List<VacationRequestEntity> vacations = employeeEntity.getVacation();
            return vacationRequestMapper.toVacationRequest(vacations);
        }
        return new ArrayList<>();
    }
}