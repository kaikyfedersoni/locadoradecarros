package com.example.demo.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.model.to.UsuarioRequestDTO;
import com.example.demo.model.to.UsuarioResponseDTO;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public List<UsuarioResponseDTO> getAll() {
        List<UsuarioResponseDTO> usuarioList = usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
        return usuarioList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/registrar")
    public void salvarUsuario(@RequestBody UsuarioRequestDTO data) {
        Usuario usuarioData = new Usuario(data);
        usuarioData.setSenha(passwordEncoder.encode(data.senha()));
        usuarioRepository.save(usuarioData);
        
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(novoUsuario.getNome());
                    usuario.setEmail(novoUsuario.getEmail());
                    usuario.setSenha(novoUsuario.getSenha());
                    novoUsuario.setRole("Cliente");
                    return usuarioRepository.save(usuario);
                })
                .orElseGet(() -> {
                    novoUsuario.setId(id);
                    return usuarioRepository.save(novoUsuario);
                });
    }

}