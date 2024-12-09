package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aluguel;
import com.example.demo.model.Carro;
import com.example.demo.model.Usuario;
import com.example.demo.model.to.AluguelRequestDTO;
import com.example.demo.model.to.AluguelResponseDTO;
import com.example.demo.repository.AluguelRepository;
import com.example.demo.repository.CarroRepository;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/aluguel")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public List<AluguelResponseDTO> getAll() {
        return aluguelRepository.findAll()
                .stream()
                .map(AluguelResponseDTO::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/alugar")
    public void salvarAluguel(@RequestBody AluguelRequestDTO data) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String emailUsuario = authentication.getName();
    Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    Carro carro = carroRepository.findById(data.carroId())
            .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

    Aluguel aluguel = new Aluguel(data, carro, usuario);
    aluguelRepository.save(aluguel);
}

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        aluguelRepository.deleteById(id);
    }

}
