package io.github.davimc.msemplocontrol.controllers;

import io.github.davimc.msemplocontrol.infra.mqueue.EmployeePublisher;
import io.github.davimc.msemplocontrol.model.HiringProtocol;
import io.github.davimc.msemplocontrol.model.HiringRequest;
import io.github.davimc.msemplocontrol.services.EmploControlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("emplo-control")
@RequiredArgsConstructor
public class EmploControlController {
    private final EmploControlService service;
    @GetMapping
    public String status() {
        return "Ok";
    }

    @PostMapping(value = "/hiring")
    public ResponseEntity<HiringProtocol> hiring(@Valid @RequestBody HiringRequest data) {
        HiringProtocol protocol = service.hiring(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(protocol);
    }
}
