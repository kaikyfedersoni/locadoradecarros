package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.CarroRepository;
import com.example.demo.model.Carro;


@Service
public class CarroService{

    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }

    public void novoCarro(Carro carro) {
        carroRepository.save(carro); 
    }
    

      public Carro alterarCarro(@RequestBody Carro novoCarro, @PathVariable Long id) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carro.setModelo(novoCarro.getModelo());
                    carro.setPlaca(novoCarro.getPlaca());
                    carro.setCor(novoCarro.getCor());
                    carro.setTipo(novoCarro.getTipo());
                    carro.setMarca(novoCarro.getMarca());
                    carro.setAno(novoCarro.getAno());
                    return carroRepository.save(carro);
                })
                .orElseGet(() -> {
                    novoCarro.setId(id);
                    return carroRepository.save(novoCarro);
                });
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public void removerCarro(@PathVariable Long id) {
        carroRepository.deleteById(id);
    }

    public Optional<Carro> buscarCarroPorId(Long id) {
        return carroRepository.findById(id);
    }

}
