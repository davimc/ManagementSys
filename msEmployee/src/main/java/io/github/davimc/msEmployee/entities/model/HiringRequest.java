package io.github.davimc.msEmployee.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.davimc.msEmployee.entities.Employee;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HiringRequest {

    @NotNull(message = "Name is necessary")
    private String name;
    @NotNull(message = "CPF is necessary")
    @CPF(message = "CPF format are not being obeyed")
    private String cpf;
    @NotNull(message = "Birthdate is necessary")
    @Past(message = "Birthdate must be in the past")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date admissionDate;
    @NotNull(message = "Salary is necessary")
    @PositiveOrZero(message = "Salary must be positive")
    private Double salary;
    @NotNull(message = "Role is necessary")
    private String role;

    private Long storeId;
    private String storeCnpj;

    public HiringRequest() {
    }

    public HiringRequest(String name, String cpf, Date birthdate, Date admissionDate, Double salary, String role, Long storeId, String storeCnpj) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.salary = salary;
        this.role = role;
        this.storeId = storeId;
        this.storeCnpj = storeCnpj;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public Double getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    public Long getStoreId() {
        return storeId;
    }

    public String getStoreCnpj() {
        return storeCnpj;
    }

    public Employee fromDTO() {
        Employee obj = new Employee();
        obj.setCpf(cpf);
        obj.setBirthdate(birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        obj.setName(name);
        obj.setSalary(salary);
        obj.setAdmissionDate(admissionDate != null? admissionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : LocalDate.now());
        obj.setRole(role);

        return obj;
    }
}
