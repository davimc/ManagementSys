package io.github.davimc.msemplocontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEmployee {
    private UUID id;
    private String name;
    private String cpf;
}
