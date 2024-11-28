package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {
    @GetMapping("/")
    public String ola(){
        return "ola mundo";
    }

    @GetMapping("/secured")
    public String secured(){
        return " hello secured ";
    }

}
