package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Carro;
import com.example.demo.model.Marca;


public interface CarroRepository extends JpaRepository<Carro, Long>{
    List<Carro> findByMarca(Marca marca);
    List<Carro> findByModeloContaining(String modelo);
    List<Carro> findByAno(int ano);

}
