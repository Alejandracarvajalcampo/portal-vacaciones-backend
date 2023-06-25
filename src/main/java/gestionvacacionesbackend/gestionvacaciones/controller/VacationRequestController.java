package gestionvacacionesbackend.gestionvacaciones.controller;

import gestionvacacionesbackend.gestionvacaciones.domain.dto.VacationRequest;
import gestionvacacionesbackend.gestionvacaciones.domain.service.VacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("vacation/")
@CrossOrigin(origins = "http://localhost:4200")
public class VacationRequestController {

    @Autowired
    private VacationRequestService vacationRequestService;

    @PostMapping("create/")
    public ResponseEntity<?> crearSolicitudVacaciones(@Valid @RequestBody VacationRequest vacationRequest) {
        try {
            VacationRequest solicitudCreada = vacationRequestService.createVacationRequest(vacationRequest);
            return new ResponseEntity<>(solicitudCreada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("calculatedays")
    public int calculateVacationsDays() {
        LocalDate admissionDate = LocalDate.of(2020, 1, 1);
        LocalDate currentDate = LocalDate.now();
        int availableDays = vacationRequestService.calculateAvailableVacationDays(admissionDate, currentDate);

        return availableDays;
    }

    @GetMapping("list/")
    public List<VacationRequest> getAllVacationRequestsSortedByDate() {
        return vacationRequestService.getAllVacationRequestsSortedByDate();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteRequestId(@PathVariable Long id) {
        vacationRequestService.deleteRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
