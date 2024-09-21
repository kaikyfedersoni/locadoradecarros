package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {
    
    private CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    public CarroController(){}

    @PostMapping
    public Carro novoCarro(@RequestBody Carro carro) {
        return carroService.novoCarro(carro);
    }

    @PutMapping("/{id}")
    public Carro alterarCarro(@RequestBody Carro novoCarro, @PathVariable String id) {
        return carroService.alterarCarro(novoCarro, id);
    }

    @GetMapping
    public List<Carro> listarTodos() {
        return carroService.listarTodos();
    }

    
    @DeleteMapping("/{id}")
    public void removerCarro(@PathVariable String id) {
        carroService.removerCarro(id);
    }
    
}

