package io.github.davimc.msstore.service;

import io.github.davimc.msstore.dto.StoreDTO;
import io.github.davimc.msstore.services.StoreService;
import io.github.davimc.msstore.services.ex.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class StoreServiceUT {

    @Autowired
    private StoreService service;

    private static Long existId;
    private Long nonExistId;
    private Long totalElements;
    private String storeName = "First Store";

    @BeforeEach
    private void setup() {
        existId = 1L;
        nonExistId = 10000L;
        totalElements = 5L;
    }
    @Test
    public void findShouldReturnStoreDTOWhenIdExist() {
        StoreDTO dto = service.find(existId);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getId(),existId);
        Assertions.assertEquals(dto.getName(),storeName);
    }

    @Test
    public void findShouldReturnExceptionWhenIdNonExists() {
        Assertions.assertThrows(ObjectNotFoundException.class, () -> service.find(nonExistId));
    }

    @Test
    public void insertShouldReturnStoreDTO() {
        Assertions.assertDoesNotThrow(() -> {
            StoreDTO dto = new StoreDTO(null, storeName);

            dto = service.insert(dto);
            Assertions.assertEquals(totalElements+1, dto.getId());
            Assertions.assertEquals(storeName, dto.getName());
        });
    }
}
