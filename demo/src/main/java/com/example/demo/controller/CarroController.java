package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carro;
import com.example.demo.model.to.CarroRequestDTO;
import com.example.demo.model.to.CarroResponseDTO;
import com.example.demo.repository.CarroRepository;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CarroResponseDTO> getAll() {
        List<CarroResponseDTO> carroList = carroRepository.findAll()
                .stream()
                .map(CarroResponseDTO::new)
                .collect(Collectors.toList());
        return carroList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void salvarCarro(@RequestBody CarroRequestDTO data) {
        Carro carroData = new Carro(data);
        carroRepository.save(carroData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletarCarro(@PathVariable Long id) {
        carroRepository.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public Carro atualizarCarro(@PathVariable Long id, @RequestBody Carro novoCarro) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carro.setMarca(novoCarro.getMarca());
                    carro.setModelo(novoCarro.getModelo());
                    carro.setAno(novoCarro.getAno());
                    carro.setPrecoDiaria(novoCarro.getPrecoDiaria());
                    carro.setUrlImagem(novoCarro.getUrlImagem());
                    carro.setCombustao(novoCarro.getCombustao());
                    carro.setMarchas(novoCarro.getMarchas());
                    return carroRepository.save(carro);
                })
                .orElseGet(() -> {
                    novoCarro.setId(id);
                    return carroRepository.save(novoCarro);
                });
    }

}
