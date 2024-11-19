package com.example.demo.model.to;




import com.example.demo.model.Marca;

public record CarroRequestDTO(Marca marca, String modelo, int ano,String urlImagem, String combustao, int marchas, double precoDiaria) {

    
    
}