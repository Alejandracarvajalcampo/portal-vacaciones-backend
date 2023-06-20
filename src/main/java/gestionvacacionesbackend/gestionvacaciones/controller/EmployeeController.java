package gestionvacacionesbackend.gestionvacaciones.controller;

import gestionvacacionesbackend.gestionvacaciones.domain.Exceptions.ResourceNotFoundException;
import gestionvacacionesbackend.gestionvacaciones.domain.service.EmployeeService;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("create/")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createEmployee(employeeEntity);
    }
    @GetMapping("list/")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("search/{id}")
    public ResponseEntity<EmployeeEntity> getEmployedById(@PathVariable long id){
        EmployeeEntity employeeEntity = employeeService.findById(id).orElseThrow(() -> new ResourceNotFoundException(("no existe el empleado con ese id:" + id)));
        return ResponseEntity.ok(employeeEntity);
    }

    @PutMapping("update/{id}")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity, @PathVariable Long id) {
        return employeeService.updateEmployee(employeeEntity, id);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee (@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
