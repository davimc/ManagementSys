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

    @Email(message = "E-mail format are not being obeyed")
    private String email;
    private String pix;
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
        this.email = email;
        this.pix = pix;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.resignationDate = resignationDate;
        this.salary = salary;
        this.role = role;
    }

    public EmployeeUpdateDTO(Employee obj) {
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.pix = obj.getPix();
        this.birthdate = obj.getBirthdate();
        this.admissionDate = obj.getAdmissionDate();
        resignationDate = obj.getResignationDate();
        salary = obj.getSalary();
        role = obj.getRole();
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPix() {
        return pix;
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
        obj.setEmail(email == null? obj.getEmail() : email);
        obj.setPix(pix == null? obj.getPix() : pix);
        obj.setAdmissionDate(admissionDate == null? obj.getAdmissionDate() : admissionDate);
        obj.setResignationDate(resignationDate == null? obj.getResignationDate() : resignationDate);
        obj.setSalary(salary == null? obj.getSalary() : salary);
        obj.setRole(role == null?obj.getRole() : role);

        return obj;
    }
}
