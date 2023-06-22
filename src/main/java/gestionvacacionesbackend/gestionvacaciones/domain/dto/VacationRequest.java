package gestionvacacionesbackend.gestionvacaciones.domain.dto;

import java.time.LocalDate;

public class VacationRequest {
    private Long id;
    private String requestType;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate hireDate;
    private Integer days;
    private LocalDate date;
    private String comment;
    private Integer document;

    public VacationRequest() {
    }

    public VacationRequest(Long id, String requestType, LocalDate startDate, LocalDate endDate, LocalDate hireDate, Integer days, LocalDate date, String comment, Integer document) {
        this.id = id;
        this.requestType = requestType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hireDate = hireDate;
        this.days = days;
        this.date = date;
        this.comment = comment;
        this.document = document;

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
}
