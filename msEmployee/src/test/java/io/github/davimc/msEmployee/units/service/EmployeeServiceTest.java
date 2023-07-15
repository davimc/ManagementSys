package io.github.davimc.msEmployee.units.service;


import io.github.davimc.msEmployee.dto.EmployeeDTO;
import io.github.davimc.msEmployee.dto.EmployeeNewDTO;
import io.github.davimc.msEmployee.entities.Employee;
import io.github.davimc.msEmployee.repository.EmployeeRepository;
import io.github.davimc.msEmployee.services.EmployeeService;
import io.github.davimc.msEmployee.tests.factory.Factory;
import io.github.davimc.msExceptionHandler.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;
    @Mock
    private EmployeeRepository repository;
    private UUID existentId;
    private UUID nonExistentId;
    private UUID dependentId;
    private Employee objWithoutId, objWithId;
    private PageRequest page;

    @BeforeEach
    private void setup() {
        existentId = UUID.fromString("458e8557-014f-4806-8f45-258d487569db");
        nonExistentId = UUID.fromString("b6fed7ab-db41-42fb-8bc8-9e7057a23e5d");
        dependentId = UUID.fromString("4944d7b2-1317-11ee-be56-0242ac120002");
        objWithoutId = Factory.createEmployee();
        objWithId = objWithoutId;
        objWithId.setId(existentId);
        page = PageRequest.of(0,10);

        Mockito.when(repository.findById(existentId)).thenReturn(Optional.of(objWithoutId));
        Mockito.when(repository.findById(nonExistentId)).thenThrow(ObjectNotFoundException.class);
        Mockito.when(repository.findAll(PageRequest.of(0, 10))).thenReturn(new PageImpl(List.of(objWithoutId)));
        Mockito.when(repository.save(Mockito.any(Employee.class))).thenReturn(objWithId);

    }
    @Test
    public void findShouldReturnAnDTOWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            EmployeeDTO dto = service.findByIdDTO(existentId);

            Assertions.assertEquals(dto.getName(), "Luci");
        });
    }
    @Test
    public void findShouldThrowObjectNotFoundWhenIdDoesntExists() {
        Assertions.assertThrows(ObjectNotFoundException.class, () -> service.findByIdDTO(nonExistentId));
    }
    @Test
    public void findAllShouldReturnPageOfObjects() {
        Assertions.assertDoesNotThrow(() -> {
            Page<EmployeeDTO> dto = service.findAll(page);

            Assertions.assertEquals(1,dto.getTotalPages());
            Assertions.assertEquals(1,dto.getTotalElements());
        });
    }
    @Test
    public void insertShouldCreateAndReturnDTOWhenNewEmployeeDTOIsValid() {
        Assertions.assertDoesNotThrow(() -> {
            EmployeeNewDTO newDTO = new EmployeeNewDTO(objWithoutId);
            EmployeeDTO dto = service.insert(newDTO);

            Assertions.assertEquals(dto.getId(), existentId);
        });
    }
}
