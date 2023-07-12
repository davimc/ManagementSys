package io.github.davimc.msexchange.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataEmployee {
    private UUID id;
    private String name;
    private String cpf;
    private Long storeId;
}
