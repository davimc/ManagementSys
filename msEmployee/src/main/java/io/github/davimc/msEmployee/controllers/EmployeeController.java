package io.github.davimc.msEmployee.controllers;

import io.github.davimc.msEmployee.dto.EmployeeDTO;
import io.github.davimc.msEmployee.dto.EmployeeNewDTO;
import io.github.davimc.msEmployee.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @GetMapping
    public ResponseEntity<String> status() {
        return ResponseEntity.ok().body("Ok");
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<EmployeeDTO>> list (Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> find(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody @Valid EmployeeNewDTO newDTO) {
        EmployeeDTO dto = service.insert(newDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }
}
