package com.example.demo.model.to;

import java.math.BigDecimal;

import com.example.demo.model.Carro;
import com.example.demo.model.Marca;

public record CarroResponseDTO(Long id,Marca marca, String modelo, int ano,String urlImagem, BigDecimal precoDiaria){
    public CarroResponseDTO(Carro carro){
        this(carro.getId(),carro.getMarca(),carro.getModelo(),carro.getAno(),carro.getUrlImagem(),carro.getPrecoDiaria());
    }
}