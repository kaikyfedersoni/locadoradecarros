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

    private String placa;
    private String modelo;
    private int ano;
    
    @Enumerated(EnumType.STRING) 
    private Marca marca;
    private String cor;
    
    @Enumerated(EnumType.STRING) 
    private Tipo tipo;
    public Carro(){}

    public Carro(Long id,String placa,Marca marca, String modelo,String cor, Tipo tipo, int ano){
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.tipo = tipo;
        this.marca = marca;
        this.ano = ano;
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

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public Tipo getTipo(){
        return tipo;
    }

    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }

    
}
