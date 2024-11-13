package com.example.demo.model.to;

import com.example.demo.model.Carro;
import com.example.demo.model.Marca;



public record CarroRequestDTO(Marca marca, String modelo, int ano,String urlImagem, double precoDiaria) {
    public CarroRequestDTO(Carro carro){
        this(carro.getMarca(),carro.getModelo(),carro.getAno(),carro.getUrlImagem(),carro.getPrecoDiaria());
    }
    
}
