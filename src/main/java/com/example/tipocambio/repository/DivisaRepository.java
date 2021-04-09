package com.example.tipocambio.repository;

import com.example.tipocambio.entity.Divisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisaRepository extends JpaRepository<Divisa, Integer> {

    Divisa findByOrigenAndDestino(String origen, String destino);
}
