package io.github.davimc.msEmployee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.davimc.msEmployee.entities.Employee;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class EmployeeUpdateDTO {

    @Size(min = 2, max = 100, message = "Name has a size min 2 and max 100")
    private String name;

    @CPF(message = "CPF format are not being obeyed")
    private String cpf;
    @Past(message = "Birthdate must be in the past")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate admissionDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate resignationDate;
    @NotBlank(message = "Role cannot be blank")
    private String role;

    @PositiveOrZero(message = "Salary must be positive")
    private Double salary;

    public EmployeeUpdateDTO() {
    }

    public EmployeeUpdateDTO(String name, String cpf, String email, String pix, LocalDate birthdate, LocalDate admissionDate, LocalDate resignationDate, Double salary, String role) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.resignationDate = resignationDate;
        this.salary = salary;
        this.role = role;
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

    public Double getSalary() {
        return salary;
    }

    public LocalDate getResignationDate() {
        return resignationDate;
    }

    public String getRole() {
        return role;
    }

    public Employee fromDTO(Employee obj) {
        obj.setCpf(cpf == null? obj.getCpf():cpf);
        obj.setBirthdate(birthdate == null? obj.getBirthdate():birthdate);
        obj.setName(name == null? obj.getName() : name);
        obj.setAdmissionDate(admissionDate == null? obj.getAdmissionDate() : admissionDate);
        obj.setResignationDate(resignationDate == null? obj.getResignationDate() : resignationDate);
        obj.setSalary(salary == null? obj.getSalary() : salary);
        obj.setRole(role == null?obj.getRole() : role);

        return obj;
    }
}
