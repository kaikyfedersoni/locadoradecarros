package com.example.demo.service;

import java.util.List;

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

    public Carro novoCarro(Carro carro){
        
        boolean carroJaExiste = carroRepository.existsById(carro.getPlaca());

        if(carroJaExiste){
            throw new RuntimeException();
        }

        return carroRepository.save(carro);
    }

      public Carro alterarCarro(@RequestBody Carro novoCarro, @PathVariable String id) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carro.setModelo(novoCarro.getModelo());
                    carro.setPlaca(novoCarro.getPlaca());
                    carro.setCor(novoCarro.getCor());
                    carro.setTipo(novoCarro.getTipo());
                    carro.setMarca(novoCarro.getMarca());
                    return carroRepository.save(carro);
                })
                .orElseGet(() -> {
                    novoCarro.setPlaca(id);
                    return carroRepository.save(novoCarro);
                });
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public void removerCarro(@PathVariable String id) {
        carroRepository.deleteById(id);
    }



     

}
