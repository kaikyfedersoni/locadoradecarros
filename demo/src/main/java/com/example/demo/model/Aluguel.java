package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;

import com.example.demo.model.to.AluguelRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate dataComeco;

    private LocalDate dataFim;

    private double valorFinal;
    
    public Aluguel(){}
    
    public Aluguel(Long id, LocalDate dataComeco, LocalDate dataFim, double valorFinal, Carro carro, Usuario usuario){
        this.id = id;
        this.carro = carro;
        this.usuario = usuario;
        this.dataComeco = dataComeco;
        this.dataFim = dataFim;
        this.valorFinal = valorFinal;
    }

    public Aluguel(AluguelRequestDTO data){
        this.carro = data.carro();
        this.usuario = data.usuario();
        this.dataComeco = data.dataComeco();
        this.dataFim = data.dataFim();
        this.valorFinal = data.valorFinal();
    }

    public void setCarro(Carro carro){
        this.carro = carro;
    }

    public void setUsuario (Usuario usuario){
        this.usuario = usuario;
    }

    public void setDataComeco (LocalDate dataComeco){
        this.dataComeco = dataComeco;
    }

    public void setDataFim (LocalDate dataFim){
        this.dataFim = dataFim;
    }

    public void setValorFinal (double valorFinal){
        Period periodo = Period.between(dataComeco,dataFim);
        double dias = periodo.getDays();
        this.valorFinal = dias*carro.getPrecoDiaria();
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public Carro getCarro(){
        return carro;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public LocalDate getDataComeco (){
        return dataComeco;
    }
    
    public LocalDate getDataFim (){
        return dataFim;
    }

    public double getValorFinal (){
        return valorFinal;
    }
}
