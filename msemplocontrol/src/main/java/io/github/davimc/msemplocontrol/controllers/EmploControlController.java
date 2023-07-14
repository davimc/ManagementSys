package io.github.davimc.msemplocontrol.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emplo-control")
public class EmploControlController {

    @GetMapping
    public String status() {
        return "Ok";
    }
}
