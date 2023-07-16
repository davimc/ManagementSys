package io.github.davimc.msemplocontrol.infra.client;

import io.github.davimc.msemplocontrol.model.DataEmployee;
import io.github.davimc.msemplocontrol.model.DataStore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msstore", path = "/stores")
public interface StoreResource {
    @GetMapping(params = "cnpj")
    ResponseEntity<DataStore> findByCnpj(@RequestParam String cnpj);
}
