package io.github.davimc.msexchange.dto;

import io.github.davimc.msexchange.domain.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDTO {
    private UUID id;
    private LocalDate created;
    private LocalDate start;
    private LocalDate end;
    private LocalDate prevision;
    private String employeeName;
    private String employeeCPF;
    private Long employeeStoreId;

    public ExchangeDTO(Exchange obj) {
        id = obj.getId();
        created = obj.getCreated();
        start = obj.getStart();
        end = obj.getEnd();
        prevision = obj.getPrevision();
        employeeName = obj.getEmployee().getName();
        employeeCPF = obj.getEmployee().getCpf();
    }
}
