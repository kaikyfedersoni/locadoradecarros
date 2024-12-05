package com.example.demo.model;

import com.example.demo.model.to.UsuarioRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String role;

    public Usuario(){}

    public Usuario(Long id,String nome,String email,String senha,String role){
        this.id =id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Usuario(UsuarioRequestDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.senha = data.senha();
        this.role = data.role();
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
