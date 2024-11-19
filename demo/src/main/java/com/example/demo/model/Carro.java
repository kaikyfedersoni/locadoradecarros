package com.example.demo.model;




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
    private int marchas;
    
    @Enumerated(EnumType.STRING) 
    private Marca marca;
    private String combustao;
    
    private String urlImagem;
    private double precoDiaria;

    public Carro(){}

    public Carro(Long id,Marca marca, String modelo, int ano,String urlImagem, String combustao, int marchas, double precoDiaria){
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.urlImagem = urlImagem;
        this.combustao = combustao;
        this.marchas = marchas;
        this.precoDiaria = precoDiaria;
    }

    public Carro(CarroRequestDTO data){
        this.modelo = data.modelo();
        this.marca = data.marca();
        this.ano = data.ano();
        this.urlImagem = data.urlImagem();
        this.combustao = data.combustao();
        this.marchas = data.marchas();
        this.precoDiaria = data.precoDiaria();

    }


    public double getPrecoDiaria(){
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria){
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

    public void setCombustao(String combustao){
        this.combustao = combustao;
    }

    public String getCombustao() {
        return combustao;
    }

    public void setMarchas(int marchas){
        this.marchas = marchas;
    }

    public int getMarchas() {
        return marchas;
    }

    
}