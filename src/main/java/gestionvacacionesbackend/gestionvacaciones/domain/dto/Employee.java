package gestionvacacionesbackend.gestionvacaciones.domain.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.time.LocalDate;


@Valid
public class Employee {

    private Long id;

    @NotNull(message = "el numero de documento solo puede ser entero no ser nulo ni estar vacio")
    private Integer document;

    private String documentType;
    @NotNull(message = "el campo de nombres no puede ser nulo ni estar vacio")
    private String names;

    private String surnames;
    @NotEmpty(message = "el telefono no puede ser nulo ni estar vacio")
    @Size(min = 6, max = 13, message = "el telefono solo acepta minimo 6 caracteres maximo 13")
    @Pattern(regexp = "^\\+\\d{1,2}\\d{6,13}$", message = "el telefono puede incluir el +57")
    private String phone;
    @NotEmpty(message = "el cargo no puede ser nulo ni estar vacio")
    private String charge;
    @NotEmpty(message = "la direccion no puede ser nulo ni estar vacio")
    private String address;
    @NotNull(message = " la fecha de contratacion no puede ser nula ni estar vacia y solo acepta este formato \"yyyy-MM-dd\" ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate admissionDate;
    @NotEmpty(message = "el tipo de contrato no puede ser nulo ni estar vacio")
    private String typeContract;
    @NotEmpty(message = "el estado no puede ser nulo ni estar vacio")
    private String state;
    @NotEmpty(message = "el supervisor no puede ser nulo ni estar vacio")
    private String supervisor;

    public Employee() {
    }

    public Employee(Long id, Integer document, String documentType, String names, String surnames, String phone, String charge, String address, LocalDate admissionDate, String typeContract, String state, String supervisor) {
        this.id = id;
        this.document = document;
        this.documentType = documentType;
        this.names = names;
        this.surnames = surnames;
        this.phone = phone;
        this.charge = charge;
        this.address = address;
        this.admissionDate = admissionDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

}
