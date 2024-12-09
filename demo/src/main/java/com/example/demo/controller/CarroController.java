package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
    @GetMapping("/listar")
    public List<CarroResponseDTO> getAll() {
        return carroRepository.findAll()
                .stream()
                .map(CarroResponseDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/adicionar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> salvarCarro(@RequestBody Carro carro) {
        System.out.println("Recebendo requisição POST para adicionar carro...");
        System.out.println("Dados recebidos: " + carro);

        try {
            Carro savedCarro = carroRepository.save(carro);
            return ResponseEntity.ok(savedCarro);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o carro");
        }
    }

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        Optional<Carro> carroOptional = carroRepository.findById(id);
        if (carroOptional.isPresent()) {
            carroRepository.delete(carroOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
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
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }
}