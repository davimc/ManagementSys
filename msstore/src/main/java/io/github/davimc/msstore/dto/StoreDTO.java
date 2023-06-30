package io.github.davimc.msstore.dto;

import io.github.davimc.msstore.entities.Store;

public class StoreDTO {
    private Long id;
    private String name;

    private String cnpj;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, String cnpj) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
    }
    public StoreDTO(Store obj) {
        id = obj.getId();
        name = obj.getName();
        cnpj = obj.getCnpj();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }
}
