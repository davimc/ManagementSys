package io.github.davimc.msemplocontrol.controllers;

import io.github.davimc.msemplocontrol.infra.client.EmployeeResource;
import io.github.davimc.msemplocontrol.infra.client.StoreResource;
import io.github.davimc.msemplocontrol.model.DataEmployee;
import io.github.davimc.msemplocontrol.model.DataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emplo-control")
@RequiredArgsConstructor
public class EmploControlController {
    private final EmployeeResource employeeResource;
    private final StoreResource storeResource;
    @GetMapping
    public String status() {
        return "Ok";
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<DataEmployee> findEmployee(@RequestParam String cpf) {
        return (employeeResource.findByCpf(cpf));
    }
    @GetMapping(params = "cnpj")
    public ResponseEntity<DataStore> findStore(@RequestParam String cnpj) {
        return (storeResource.findByCnpj(cnpj));
    }


}
