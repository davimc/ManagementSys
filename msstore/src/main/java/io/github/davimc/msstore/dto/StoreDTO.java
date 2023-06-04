package io.github.davimc.msstore.dto;

import io.github.davimc.msstore.entities.Store;

public class StoreDTO {
    private Long id;
    private String name;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public StoreDTO(Store obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
