package io.github.davimc.msEmployee.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<String> status() {
        return ResponseEntity.ok().body("Ok");
    }
}
