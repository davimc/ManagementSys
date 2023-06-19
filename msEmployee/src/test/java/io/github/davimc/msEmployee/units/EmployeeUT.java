package io.github.davimc.msEmployee.units;


import io.github.davimc.msExceptionHandler.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@ExtendWith(EmployeeService.class)
public class EmployeeUT {
    @Autowired
    private EmployeeService service;


    private Long existentId;
    private Long nonExistentId;
    private Long total;

    @BeforeAll
    private void setup() {
        existentId = 1L;
        nonExistentId = 1000L;
        total = 23L;
    }
    @Test
    public void findShouldReturnAnDTOWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            EmployeeDTO dto = service.find(existentId);
            Assertions.assertEquals(dto.getId(), existentId);
            Assertions.assertEquals(dto.getName(), "Huguinho");
        });
    }
    @Test
    public void findShouldThrowObjectNotFoundWhenIdDoesntExists() {
        Assertions.assertThrows(ObjectNotFoundException.class, () -> service.find(nonExistentId));
    }


}
