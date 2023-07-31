package io.github.davimc.msEmployee.dto;

import io.github.davimc.msEmployee.entities.Employee;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class EmployeeDTO {
    private UUID id;
    private String name;
    private String cpf;
    private LocalDate birthdate;
    private LocalDate admissionDate;
    private LocalDate resignationDate;
    private Double salary;
    private String role;

    public EmployeeDTO() {
    }

    public EmployeeDTO(UUID id, String name, String cpf, LocalDate birthdate, LocalDate admissionDate, LocalDate resignationDate, Double salary, String role) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.resignationDate = resignationDate;
        this.salary = salary;
        this.role = role;
    }
    public EmployeeDTO(Employee obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.birthdate = obj.getBirthdate();
        this.admissionDate = obj.getAdmissionDate();
        this.resignationDate = obj.getResignationDate();
        salary = obj.getSalary();
        role = obj.getRole();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getResignationDate() {
        return resignationDate;
    }

    public Double getSalary() {
        return salary;
    }


    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
