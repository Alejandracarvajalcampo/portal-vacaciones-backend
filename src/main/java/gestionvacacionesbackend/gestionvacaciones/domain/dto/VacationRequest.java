package gestionvacacionesbackend.gestionvacaciones.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacationRequest {
    private Long id;
    @NotEmpty(message = "el tipo de solicitud no puede ser nulo ni estar vacio")
    private String requestType;
    @NotNull(message = "la fecha de inicio de solicitud no ser nulo ni estar vacio")
    private LocalDate startDate;
    @NotNull(message = "la fecha de fin de solicitud no ser nulo ni estar vacio")
    private LocalDate endDate;
    private LocalDate hireDate;
    @NotNull(message = "los dias a solicitar solo puede ser entero no ser nulo ni estar vacio")
    private Integer days;
    private LocalDate date;
    private String comment;
    @NotNull(message = "el numero de documento solo puede ser entero no ser nulo ni estar vacio")
    private Integer document;
    @NotNull(message = "el estado no puede ser nulo ni estar vacio")
    private String state;

    public VacationRequest() {
    }

    public VacationRequest(Long id, String requestType, LocalDate startDate, LocalDate endDate, LocalDate hireDate, Integer days, LocalDate date, String comment, Integer document,String state) {
        this.id = id;
        this.requestType = requestType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hireDate = hireDate;
        this.days = days;
        this.date = date;
        this.comment = comment;
        this.document = document;
        this.state = state;

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

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
