package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ola")
public class HealthController {
    @GetMapping
    public String ola(){
        return "ola mundo";
    }

}
