package com.example.demo.model.to;

import java.time.LocalDate;

public record AluguelRequestDTO(
    LocalDate dataComeco,
    LocalDate dataFim,
    Long carroId 
) {}



