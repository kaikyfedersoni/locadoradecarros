package com.example.demo.model.to;

import com.example.demo.model.Usuario;

public record UsuarioRequestDTO(String nome,String email,String senha){
    public UsuarioRequestDTO(Usuario usuario){
        this(usuario.getNome(),usuario.getEmail(),usuario.getSenha());

    }
    
}
