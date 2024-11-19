package com.example.demo.model.to;

import java.time.LocalDate;

import com.example.demo.model.Aluguel;
import com.example.demo.model.Carro;
import com.example.demo.model.Usuario;

public record AluguelResponseDTO(Long id,LocalDate dataComeco, LocalDate dataFim, double valorFinal, Carro carro, Usuario usuario) {
    public AluguelResponseDTO(Aluguel aluguel){
        this(aluguel.getId(),aluguel.getDataComeco(),aluguel.getDataFim(),aluguel.getValorFinal(),aluguel.getCarro(),aluguel.getUsuario());
    }
    
}
