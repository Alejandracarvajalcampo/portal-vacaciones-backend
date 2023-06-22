package gestionvacacionesbackend.gestionvacaciones.domain.dto;

import gestionvacacionesbackend.gestionvacaciones.persistence.entities.VacationRequestEntity;

import java.time.LocalDate;
import java.util.List;

public class Employee {

    private Long id;

    private Integer document;

    private String documentType;

    private String names;

    private String surnames;

    private Integer phone;

    private String charge;

    private String address;

    private LocalDate admissionDate;

    private LocalDate withdrawalDate;

    private String typeContract;

    private String state;
    private String supervisor;

    public Employee() {
    }

    public Employee(Long id, Integer document, String documentType, String names, String surnames, Integer phone, String charge, String address, LocalDate admissionDate, LocalDate withdrawalDate, String typeContract, String state, String supervisor) {
        this.id = id;
        this.document = document;
        this.documentType = documentType;
        this.names = names;
        this.surnames = surnames;
        this.phone = phone;
        this.charge = charge;
        this.address = address;
        this.admissionDate = admissionDate;
        this.withdrawalDate = withdrawalDate;
        this.typeContract = typeContract;
        this.state = state;
        this.supervisor = supervisor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public List<VacationRequestEntity> getVacation() {
        return getVacation();
    }
}
