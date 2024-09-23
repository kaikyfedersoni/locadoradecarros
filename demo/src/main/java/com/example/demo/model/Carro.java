package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Carro {
   
    @Id
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    
    @Enumerated(EnumType.STRING) 
    private Tipo tipo;

    public Carro(){}

    public Carro(String placa,String marca, String modelo,String cor, Tipo tipo ){
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.tipo = tipo;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
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
