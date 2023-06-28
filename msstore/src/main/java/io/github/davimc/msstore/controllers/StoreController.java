package io.github.davimc.msstore.controllers;

import io.github.davimc.msstore.dto.StoreDTO;
import io.github.davimc.msstore.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService service;


    @GetMapping
    public String status() {
        return "Ok";
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<StoreDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<StoreDTO> find(@PathVariable Long id) {
        StoreDTO dto = service.find(id);

        return ResponseEntity.ok().body(dto);
    }
}
