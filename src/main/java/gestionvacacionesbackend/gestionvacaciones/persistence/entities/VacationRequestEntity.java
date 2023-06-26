package gestionvacacionesbackend.gestionvacaciones.persistence.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "solicitud_vacaciones")
@Entity
public class VacationRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_solicitud")
    private String requestType;
    @Column(name = "fecha_inicio")
    private LocalDate startDate;
    @Column(name = "fecha_fin")
    private LocalDate endDate;
    @Column(name = "fecha_contratacion")
    private LocalDate hireDate;
    @Column(name = "dias")
    private Integer days;
    @Column(name = "fecha")
    private LocalDate date;
    @Column(name = "comentario")
    private String comment;
    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "empleado_id")
    private EmployeeEntity employee;

    public VacationRequestEntity() {
    }

    public VacationRequestEntity(Long id, String requestType, LocalDate startDate, LocalDate endDate, LocalDate hireDate, Integer days, LocalDate date, String comment, String state, EmployeeEntity employee) {
        this.id = id;
        this.requestType = requestType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hireDate = hireDate;
        this.days = days;
        this.date = date;
        this.comment = comment;
        this.state = state;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
