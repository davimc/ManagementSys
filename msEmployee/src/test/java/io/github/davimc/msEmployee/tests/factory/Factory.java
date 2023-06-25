package io.github.davimc.msEmployee.tests.factory;

import io.github.davimc.msEmployee.dto.EmployeeDTO;
import io.github.davimc.msEmployee.entities.Employee;

import java.time.LocalDate;

public class Factory {


    public static Employee createEmployee() {
        return new Employee("Luci","569.307.080-89","luci@gmail.com","241546431223", LocalDate.of(2000, 2,23), LocalDate.now(), 3700.00);
    }
    public static EmployeeDTO createEmployeeDTO() {
        return new EmployeeDTO(createEmployee());
    }
}
