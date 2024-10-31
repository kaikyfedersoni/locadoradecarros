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
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public Carro salvarCarro(@RequestBody Carro carro) {
         return carroService.novoCarro(carro); 
    }   

    @GetMapping
    public List<Carro> listarCarros(){
        return carroService.listarTodos();
    }
    
    @PutMapping("/{id}")
    public Carro atualizarCarro(@PathVariable Long id,@RequestBody Carro carroatualizado){
        return carroService.alterarCarro(carroatualizado, id);
    }

    @DeleteMapping("/{id}")
    public void apagarCarro(@PathVariable Long id){
        carroService.removerCarro(id);
    }

    
}
