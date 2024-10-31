package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Carro {
   
    @Id
    @GeneratedValue
    private Long id;

    private String modelo;
    private int ano;
    
    @Enumerated(EnumType.STRING) 
    private Marca marca;
    
    private String urlImagem;

    public Carro(){}

    public Carro(Long id,Marca marca, String modelo, int ano,String urlImagem){
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.urlImagem = urlImagem;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return id;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca){
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem){
        this.urlImagem = urlImagem;
    }

    

    
}
