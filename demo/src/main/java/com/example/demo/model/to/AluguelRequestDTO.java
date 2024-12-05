package com.example.demo.model.to;

import java.time.LocalDate;

import com.example.demo.model.Carro;
import com.example.demo.model.Usuario;

public record AluguelRequestDTO(LocalDate dataComeco, LocalDate dataFim, double valorFinal, Carro carro, Usuario usuario) {
   
}



