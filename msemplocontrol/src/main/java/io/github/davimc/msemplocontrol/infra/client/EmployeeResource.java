package io.github.davimc.msemplocontrol.infra.client;

import io.github.davimc.msemplocontrol.model.DataEmployee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msemployee", path = "/employees")
public interface EmployeeResource {
    @GetMapping(params = "cpf")
    ResponseEntity<DataEmployee> findByCpf(@RequestParam String cpf);
}
