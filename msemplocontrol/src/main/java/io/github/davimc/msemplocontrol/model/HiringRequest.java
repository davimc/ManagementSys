package io.github.davimc.msemplocontrol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Data
@NoArgsConstructor
public class HiringRequest {
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "CPF cannot be null")
    @CPF(message = "CPF is not obeying the rule")
    private String cpf;
    @NotNull(message = "Birthdate cannot be null")
    @Past(message = "Birthdate cannot be present or future date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date admissionDate;
    @NotNull(message = "Salary cannot be null")
    @PositiveOrZero(message = "Salary cannot be negative")
    private Double salary;

    @NotNull(message = "Role cannot be null")
    private String role;
    private Long storeId;
    @NotNull(message = "CNPJ cannot be null")
    @CNPJ(message = "CPF is not obeying the rule")
    private String storeCnpj;
}
