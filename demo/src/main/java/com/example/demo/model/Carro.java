package com.example.demo.model;


import java.math.BigDecimal;

import com.example.demo.model.to.CarroRequestDTO;

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
    private BigDecimal precoDiaria;

    public Carro(){}

    public Carro(Long id,Marca marca, String modelo, int ano,String urlImagem, BigDecimal precoDiaria){
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.urlImagem = urlImagem;
        this.precoDiaria = precoDiaria;
    }

    public Carro(CarroRequestDTO data){
        this.modelo = data.modelo();
        this.marca = data.marca();
        this.ano = data.ano();
        this.urlImagem = data.urlImagem();
        this.precoDiaria = data.precoDiaria();

    }


    public BigDecimal getPrecoDiaria(){
        return precoDiaria;
    }

    public void setPrecoDiaria(BigDecimal precoDiaria){
        this.precoDiaria=precoDiaria;
        
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
