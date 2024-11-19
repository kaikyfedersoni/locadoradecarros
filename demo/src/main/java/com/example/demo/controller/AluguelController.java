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

import com.example.demo.model.Aluguel;
import com.example.demo.model.to.AluguelRequestDTO;
import com.example.demo.model.to.AluguelResponseDTO;
import com.example.demo.repository.AluguelRepository;


@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AluguelResponseDTO> getAll() {
        List<AluguelResponseDTO> aluguelList = aluguelRepository.findAll()
                .stream()
                .map(AluguelResponseDTO::new)
                .collect(Collectors.toList());
        return aluguelList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void salvarUsuario(@RequestBody AluguelRequestDTO data) {
        Aluguel aluguelData = new Aluguel(data);
        aluguelRepository.save(aluguelData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        aluguelRepository.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public Aluguel atualizarUsuario(@PathVariable Long id, @RequestBody Aluguel novoAluguel) {
        return aluguelRepository.findById(id)
                .map(aluguel -> {
                    aluguel.setDataComeco(novoAluguel.getDataComeco());
                    aluguel.setDataFim(novoAluguel.getDataFim());
                    aluguel.setCarro(novoAluguel.getCarro());
                    aluguel.setUsuario(novoAluguel.getUsuario());
                    aluguel.setValorFinal(novoAluguel.getValorFinal());
                    return aluguelRepository.save(aluguel);
                })
                .orElseGet(() -> {
                    novoAluguel.setId(id);
                    return aluguelRepository.save(novoAluguel);
                });
    }

}
