package gestionvacacionesbackend.gestionvacaciones.domain.service;


import gestionvacacionesbackend.gestionvacaciones.domain.dto.VacationRequest;
import gestionvacacionesbackend.gestionvacaciones.domain.repository.EmployeeRepository;
import gestionvacacionesbackend.gestionvacaciones.domain.repository.VacationRequestRepository;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.EmployeeEntity;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.VacationRequestEntity;
import gestionvacacionesbackend.gestionvacaciones.persistence.mappers.VacationRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class VacationRequestService {

    @Autowired
    private VacationRequestRepository vacationRequestRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private VacationRequestMapper vacationRequestMapper;


    public VacationRequest createVacationRequest(VacationRequest vacationRequest) throws Exception {
        LocalDate date = LocalDate.now();
        vacationRequest.setDate(date);
        LocalDate startDate = vacationRequest.getStartDate();
        LocalDate endDate = vacationRequest.getEndDate();
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        if (daysBetween < 5) {
            throw new Exception("Se deben solicitar al menos 6 días hábiles consecutivos.");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate minimumDate = currentDate.plusDays(15);
        if (startDate.isBefore(minimumDate)) {
            throw new Exception("Se deben solicitar las vacaciones con al menos 15 días de anticipación.");
        }

        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findByDocument(vacationRequest.getDocument());
        EmployeeEntity employeeEntity = employeeEntityOptional.orElseThrow(() -> new Exception("No se encontró ningún empleado con el documento proporcionado."));

        LocalDate hireDate = employeeEntity.getAdmissionDate();
        LocalDate probationEndDate = hireDate.plusMonths(2);
        if (currentDate.isBefore(probationEndDate)) {
            throw new Exception("Debes haber cumplido el periodo de prueba de al menos 2 meses para solicitar anticipos de vacaciones.");
        }
        LocalDate anniversaryDate = hireDate.plusYears(1);
        if (currentDate.isBefore(anniversaryDate)) {
            throw new Exception("Las vacaciones se causan después de un año laborado.");
        }

        VacationRequestEntity vacationRequestEntity = vacationRequestMapper.toVacationRequestEntity(vacationRequest);
        vacationRequestEntity.setEmployee(employeeEntity);
        vacationRequestEntity = vacationRequestRepository.save(vacationRequestEntity);

        return vacationRequestMapper.toVacationRequest(vacationRequestEntity);
    }

    public List<VacationRequest> getAllVacationRequestsSortedByDate() {
        List<VacationRequestEntity> vacationRequestEntities = (List<VacationRequestEntity>) vacationRequestRepository.findAll();
        List<VacationRequest> vacationRequests = new ArrayList<>();

        for (VacationRequestEntity vacationRequestEntity : vacationRequestEntities) {
            VacationRequest vacationRequest = vacationRequestMapper.toVacationRequest(vacationRequestEntity);
            vacationRequests.add(vacationRequest);
        }

        vacationRequests.sort(Comparator.comparing(VacationRequest::getDate));

        return vacationRequests;
    }

    public void deleteRequest(Long id) {
        vacationRequestRepository.deleteById(id);
    }



}
