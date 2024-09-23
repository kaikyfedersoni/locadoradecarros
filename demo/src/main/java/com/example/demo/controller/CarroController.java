package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 

import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;

@Controller
@RequestMapping("/carros")
public class CarroController {
    
    private CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    public CarroController(){}

    @PostMapping
    public String salvarCarro(@ModelAttribute Carro carro) {
        carroService.novoCarro(carro);
        return "redirect:/carros";
    }   

    @GetMapping("/editar/{id}")
    public String editarCarro(@PathVariable String id, Model model) {
        Optional<Carro> carro = carroService.buscarCarroPorId(id);   
        model.addAttribute("carro", carro);
        return "pages/formCarro"; // Reutiliza o template de formulário
    }

    @PostMapping("/editar/{id}")
    public String alterarCarro(@ModelAttribute Carro novoCarro, @PathVariable String id) {
        carroService.alterarCarro(novoCarro, id);
        return "redirect:/carros";
    }

    @GetMapping
    public String listarTodos(Model model) {
        List<Carro> carros = carroService.listarTodos();
        model.addAttribute("carros", carros);
        return "pages/listarCarros";
    }

    @GetMapping("/novo")
    public String novoCarroForm(Model model) {
        model.addAttribute("carro", new Carro());
        return "pages/formCarro"; 
    }

    
    @GetMapping("/remover/{id}")
    public String removerCarro(@PathVariable String id) {
        carroService.removerCarro(id);
        return "redirect:/carros";
    }
    
}

