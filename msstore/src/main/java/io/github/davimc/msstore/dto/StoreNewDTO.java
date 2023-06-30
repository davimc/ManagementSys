package io.github.davimc.msstore.dto;

import io.github.davimc.msstore.entities.Store;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;

public class StoreNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "É necessário informar um nome")
    private String name;

    @NotNull(message = "É necessário informar um cnpj")
    @CNPJ(message = "Regra de CNPJ não está sendo obedecida")
    private String cnpj;

    public StoreNewDTO() {
    }

    public StoreNewDTO(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }
    public StoreNewDTO(Store obj) {
        name = obj.getName();
        cnpj = obj.getCnpj();
    }


    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Store fromDTO() {
        Store obj = new Store();
        obj.setName(getName());
        obj.setCnpj(getCnpj());

        return obj;
    }
}
