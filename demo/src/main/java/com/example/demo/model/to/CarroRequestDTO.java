package com.example.demo.model.to;

import java.math.BigDecimal;

import com.example.demo.model.Marca;

public record CarroRequestDTO(Marca marca, String modelo, int ano,String urlImagem, BigDecimal precoDiaria) {
    
    
}
