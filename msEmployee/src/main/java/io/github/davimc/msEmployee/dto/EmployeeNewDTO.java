package io.github.davimc.msEmployee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.davimc.msEmployee.entities.Employee;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class EmployeeNewDTO {

    @NotNull(message = "Name is necessary")
    private String name;

    @NotNull(message = "CPF is necessary")
    @CPF(message = "CPF format are not being obeyed")
    private String cpf;

    @NotNull(message = "E-mail is necessary")
    @Email(message = "E-mail format are not being obeyed")
    private String email;
    private String pix;

    @NotNull(message = "Birthdate is necessary")
    @Past(message = "Birthdate must be in the past")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    @NotNull(message = "Admission date is necessary")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate admissionDate;

    @NotNull(message = "Salary is necessary")
    @PositiveOrZero(message = "Salary must be positive")
    private Double salary;

    public EmployeeNewDTO() {
    }

    public EmployeeNewDTO(String name, String cpf, String email, String pix, LocalDate birthdate, LocalDate admissionDate, LocalDate resignationDate, Double salary) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.pix = pix;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.salary = salary;
    }
    public EmployeeNewDTO(Employee obj) {
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.pix = obj.getPix();
        this.birthdate = obj.getBirthdate();
        this.admissionDate = obj.getAdmissionDate();
        salary = obj.getSalary();
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

    public Employee fromDTO() {
        Employee obj = new Employee();
        obj.setCpf(cpf);
        obj.setBirthdate(birthdate);
        obj.setName(name);
        obj.setEmail(email);
        obj.setPix(pix);
        obj.setAdmissionDate(admissionDate);
        obj.setSalary(salary);

        return obj;
    }
}
