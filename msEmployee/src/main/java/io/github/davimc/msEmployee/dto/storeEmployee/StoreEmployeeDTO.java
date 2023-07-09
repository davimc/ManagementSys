package io.github.davimc.msEmployee.dto.storeEmployee;

import io.github.davimc.msEmployee.entities.StoreEmployee;

import java.io.Serializable;
import java.util.Objects;

public class StoreEmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cnpj;
    private String name;

    public StoreEmployeeDTO() {
    }

    public StoreEmployeeDTO(Long id, String cnpj, String name) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
    }
    public StoreEmployeeDTO(StoreEmployee obj) {
        id = obj.getId();
        this.cnpj = obj.getName();
//        this.name = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreEmployeeDTO that = (StoreEmployeeDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
