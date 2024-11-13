package com.example.demo.model.to;

import com.example.demo.model.Usuario;

public record UsuarioResponseDTO(Long id,String nome,String email,String senha){
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getSenha());

    }
}
